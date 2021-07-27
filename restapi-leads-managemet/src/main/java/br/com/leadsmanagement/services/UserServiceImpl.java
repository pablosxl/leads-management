package br.com.leadsmanagement.services;

import org.springframework.stereotype.Service;

import br.com.leadsmanagement.domain.User;
import br.com.leadsmanagement.repositories.UserRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserServiceImpl  implements UserService{
	
	private UserRepository userRepository;
	
	@Override
	public Mono<User> getUserById(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId);
	}

}
