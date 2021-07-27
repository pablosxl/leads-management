package br.com.leadsmanagement.services;

import org.bson.types.ObjectId;

import br.com.leadsmanagement.domain.Phone;
import reactor.core.publisher.Mono;

public interface PhoneService {
	
	public Mono<ObjectId> create(final Phone phone);
	public Mono<Phone> update(final String number, final ObjectId leadId);
}
