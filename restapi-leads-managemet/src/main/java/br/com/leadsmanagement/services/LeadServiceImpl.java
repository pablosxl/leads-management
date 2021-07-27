package br.com.leadsmanagement.services;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import br.com.leadsmanagement.domain.Lead;
import br.com.leadsmanagement.domain.LeadStatusEnum;
import br.com.leadsmanagement.domain.User;
import br.com.leadsmanagement.pipedrive.Deal;
import br.com.leadsmanagement.pipedrive.Note;
import br.com.leadsmanagement.pipedrive.Organization;
import br.com.leadsmanagement.pipedrive.Person;
import br.com.leadsmanagement.pipedrive.PipeDriveGateway;
import br.com.leadsmanagement.pipedrive.PipeDriveGatewayImpl;
import br.com.leadsmanagement.problemdetails.ConflictException;
import br.com.leadsmanagement.problemdetails.NotFoundException;
import br.com.leadsmanagement.repositories.LeadRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;
import sun.awt.SunHints.Value;


@Service
@AllArgsConstructor
public class LeadServiceImpl implements LeadService {
	
	private LeadRepository leadRepository;
	private PhoneService phoneService;
	private UserService userService;
	
	@Override
	public Mono<Lead> create(final Lead lead) {
		// TODO Auto-generated method stub
		
		return this.leadRepository.getLeadByEmail(lead.getEmail())
				.flatMap(result -> {
					if(result.getStatus().equals(LeadStatusEnum.LOST.getDescription()) || result.getStatus().equals(LeadStatusEnum.WON.getDescription()))
						return this.updateLead(result.get_id().toHexString(), lead);
					
					return Mono.just(result);
				})
				.switchIfEmpty(
					  this.leadRepository.insert(lead).flatMap(value -> {
						
						if(!value.getPhone().isEmpty()) { 
							value.getPhone().forEach(item -> {
								item.setLeadId(value.get_id());
								
								 this.phoneService.create(item).subscribe();
							});
						}
						
						return Mono.just(value);
				})
		);
	}

	@Override
	public Mono<Lead> finishLead(final String id, String status) {
		// TODO Auto-generated method stub
		
		return this.leadRepository.findById(id).flatMap(item -> {
			
			if(item.getStatus().equals(LeadStatusEnum.LOST.getDescription()) || item.getStatus().equals(LeadStatusEnum.WON.getDescription()))
				return Mono.error(new ConflictException("O lead já foi finalizado"));
			
			if(LeadStatusEnum.getDescriptionByName(status).equals(null))
				return Mono.error(new ConflictException("status inválido"));
				
			item.setStatus(LeadStatusEnum.getDescriptionByName(status));
			
			
			
			return this.leadRepository.save(item).flatMap(result -> {
				
				if(LeadStatusEnum.getDescriptionByName(status).equals(LeadStatusEnum.WON.getDescription()))
					this.getUserAndcreatePipeDriveDeal(item).subscribe();
				return Mono.just(result);
			});
		})
		.switchIfEmpty(Mono.error(new Throwable("Error ao atualizar o Lead")));
	}
	
	private Mono<Lead> updateLead(String leadId, Lead lead) {
		return this.leadRepository.findById(leadId).flatMap(value -> {
			
			if(lead.getCompany() != null)
				value.setCompany(lead.getCompany());
			
			if(lead.getEmail() != null)
				value.setEmail(lead.getEmail());
			
			if(lead.getName() != null)
				value.setName(lead.getName());
			
			if(lead.getNote() != null)
				value.setNote(lead.getNote());
			
			if(!value.getPhone().isEmpty()) {
				 value.getPhone().forEach(item -> {
					item.setLeadId(value.get_id());
					 this.phoneService.create(item).subscribe();
				});
			}
			
			if(lead.getSite() != null)
				value.setSite(lead.getSite());
			
			if(lead.getUserId() != null)
				value.setUserId(lead.getUserId());
			
			return this.leadRepository.save(value);
		});
	}
	
	private Mono<Void> getUserAndcreatePipeDriveDeal(Lead lead) {
		this.userService.getUserById(lead.getUserId().toHexString()).subscribe(user -> {
			
			try {
				PipeDriveGateway pipeDriveGateway = new PipeDriveGatewayImpl();
				
				Organization organization = new Organization(lead.getCompany(), lead.getSite());
				JSONObject organizationResponse = pipeDriveGateway.createOrganization(organization);
				
				Person person = new Person(user.getName(), user.getEmail());
				JSONObject personResponse = pipeDriveGateway.createPerson(person);
				
				Deal deal = new Deal(lead.getName(), "USD", organizationResponse.getIntValue("id"), lead.getStatus());
				JSONObject dealResponse = pipeDriveGateway.createDeal(deal);
				
				Note note = new Note(lead.getNote(), dealResponse.getInteger("id"));
				JSONObject noteResponse = pipeDriveGateway.createNote(note);
				
				
			} catch (Exception ex) {
				Mono.error(new Throwable("Erro ao interar com o Pipe Drive", ex));
			}
			
		});
		return Mono.empty();
	}
}
