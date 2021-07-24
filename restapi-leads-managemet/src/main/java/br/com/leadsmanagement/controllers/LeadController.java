package br.com.leadsmanagement.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.leadsmanagement.domain.Lead;
import br.com.leadsmanagement.services.LeadService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class LeadController {

	private final LeadService leadService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/lead")
	Mono<Lead> create(){
		
		 Mono<Lead> value = leadService.create();
		 
		 return value;
	}
}
