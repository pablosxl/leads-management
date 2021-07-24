package br.com.leadsmanagement.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.com.leadsmanagement.domain.Lead;

public interface LeadRepository extends ReactiveMongoRepository<Lead, String>{

}
