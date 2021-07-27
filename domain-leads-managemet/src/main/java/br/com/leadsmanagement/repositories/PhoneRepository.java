package br.com.leadsmanagement.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import br.com.leadsmanagement.domain.Phone;
import reactor.core.publisher.Mono;

@Repository
public interface PhoneRepository extends ReactiveMongoRepository<Phone, String>{
	
	@Query(value="{ 'number' : ?0, 'leadId' : ?1 }")
	Mono<Phone> getByNumberAndLeadId(final String number, final ObjectId leadId);
}
