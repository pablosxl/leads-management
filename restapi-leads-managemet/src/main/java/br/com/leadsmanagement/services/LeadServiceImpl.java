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
import br.com.leadsmanagement.repositories.LeadRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;
import sun.awt.SunHints.Value;


@Service
@AllArgsConstructor
public class LeadServiceImpl implements LeadService {
	
	private LeadRepository leadRepository;
	private PhoneService phoneService;
	
	@Override
	public Mono<Lead> create(final Lead lead) {
		// TODO Auto-generated method stub
		
		Mono<Lead> leadExists = this.verifyExistLead(lead);
		
		return leadExists.flatMap(result -> {
			
			if(result == null) {
				return leadRepository.insert(lead).doOnNext(value -> {
					
					if(!value.getPhone().isEmpty()) {
						value.getPhone().forEach(item -> {
							item.setLeadId(value.get_id());
							this.phoneService.create(item);
						});
					}
					
					
				});
			} else {
				return this.updateLead(result.get_id().toHexString(), lead);
			}
		});
		
	}

	@Override
	public Mono<Void> finishLead(final String id) {
		// TODO Auto-generated method stub
		
		leadRepository.findById(id).subscribe(item -> {
			item.setStatus(LeadStatusEnum.LOST.getDescription());
			
			leadRepository.save(item);
		});
		
		return Mono.empty();
	}
	
	private Mono<Lead> verifyExistLead(Lead lead) {
		
		return this.leadRepository.getLeadByEmail(lead.getEmail())
				.map(item -> item);
	}
	
	private Mono<Lead> updateLead(String leadId, Lead lead) {
		
		return this.leadRepository.findById(leadId).flatMap(value -> {
			
			if(lead.getCompany() != null)
				value.setCompany(lead.getCompany());
			
			if(lead.getEmail() != null)
				value.setEmail(lead.getEmail());
			
			if(lead.getName() != null)
				value.setName(lead.getName());
			
			if(!lead.getPhone().isEmpty()) {
				/*
				 * lead.getPhone().forEach(item -> { this.updatePhone(item.getNumber(),
				 * item.getLeadId()); });
				 */
			}
			
			if(lead.getSite() != null)
				value.setSite(lead.getStatus());
			
			if(lead.getUserId() != null)
				value.setUserId(lead.getUserId());
			
			return this.leadRepository.save(value);
		});
	}
	
	private void updatePhone(final String number, final ObjectId leadId) {
		this.phoneService.update(number, leadId);
	}
	
	private ResponseEntity<String> createPipeDriveDeal(Lead lead, User user) {
		
		PipeDriveGateway pipeDriveGateway = new PipeDriveGatewayImpl();
		
		Organization organization = new Organization(lead.getCompany(), lead.getSite());
		ResponseEntity<JSONObject> organizationResponse = pipeDriveGateway.createOrganization(organization);
		
		Person person = new Person(user.getName(), user.getEmail());
		ResponseEntity<JSONObject> personResponse = pipeDriveGateway.createPerson(person);
		
		Deal deal = new Deal(lead.getName(), "USD", 0);
		ResponseEntity<JSONObject> dealResponse = pipeDriveGateway.createDeal(deal);
		
		Note note = new Note(lead.getNote());
		ResponseEntity<JSONObject> noteResponse = pipeDriveGateway.createNote(note);
		
		return null;
	}
}
