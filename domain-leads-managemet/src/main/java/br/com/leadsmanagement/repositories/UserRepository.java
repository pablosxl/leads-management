package br.com.leadsmanagement.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import br.com.leadsmanagement.domain.User;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String>{

}
