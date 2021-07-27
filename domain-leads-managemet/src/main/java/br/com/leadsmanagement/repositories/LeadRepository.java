package br.com.leadsmanagement.repositories;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import br.com.leadsmanagement.domain.Lead;
import reactor.core.publisher.Mono;

@Repository
public interface LeadRepository extends ReactiveMongoRepository<Lead, String>{
	
	@Query(value="{ 'email' : ?0 }")
	Mono<Lead> getLeadByEmail(final String email);
}
