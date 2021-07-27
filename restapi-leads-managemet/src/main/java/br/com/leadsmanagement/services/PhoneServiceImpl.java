package br.com.leadsmanagement.services;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import br.com.leadsmanagement.domain.Phone;
import br.com.leadsmanagement.repositories.PhoneRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PhoneServiceImpl implements PhoneService{
	
	private PhoneRepository phoneRepository;
	
	@Override
	public Mono<ObjectId> create(Phone phone) {
		// TODO Auto-generated method stub
		return phoneRepository.insert(phone).map(value -> value.get_id());
	}
	
	@Override
	public Mono<Phone> update(final String number, final ObjectId leadId) {
		// TODO Auto-generated method stub
		return this.phoneRepository.getByNumberAndLeadId(number, leadId).flatMap(phone -> {
			
			phone.setNumber(number);
			
			return this.phoneRepository.save(phone);
		});
	}
}
