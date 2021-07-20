package br.com.leadsmanagement.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.com.leadsmanagement.domain.User;

public interface UserRepository extends ReactiveMongoRepository<User, String>{

}
