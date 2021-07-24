package br.com.leadsmanagement.services;

import org.springframework.stereotype.Service;

import br.com.leadsmanagement.services;
import br.com.leadsmanagement.domain.Lead;
import br.com.leadsmanagement.domain.LeadStatusEnum;
import br.com.leadsmanagement.repositories.LeadRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class LeadServiceImpl implements LeadService {
	
	private LeadRepository leadRepository;
	
	@Override
	public Mono<Lead> create() {
		// TODO Auto-generated method stub
		
		Lead lead = new Lead();
		
		return leadRepository.insert(lead);
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

}
