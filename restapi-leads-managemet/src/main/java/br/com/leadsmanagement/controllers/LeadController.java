package br.com.leadsmanagement.controllers;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.leadsmanagement.converters.LeadCreateRequestConverter;
import br.com.leadsmanagement.domain.Lead;
import br.com.leadsmanagement.request.LeadCreateRequest;
import br.com.leadsmanagement.services.LeadService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class LeadController {

	private final LeadService leadService;
	
	private final LeadCreateRequestConverter leadCreateRequestConverter;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/lead")
	Mono<Lead> create(@RequestBody LeadCreateRequest request) {
		
		Lead lead = this.leadCreateRequestConverter.convert(request);
		
		 Mono<Lead> value = leadService.create(lead);
		 
		 return value;
	}
	
}
