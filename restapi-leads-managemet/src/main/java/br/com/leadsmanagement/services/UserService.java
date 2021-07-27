package br.com.leadsmanagement.services;

import br.com.leadsmanagement.domain.User;
import reactor.core.publisher.Mono;

public interface UserService {
	
	public Mono<User> getUserById(final String userId);
}
