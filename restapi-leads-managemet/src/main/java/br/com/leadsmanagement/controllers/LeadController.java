package br.com.leadsmanagement.controllers;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.leadsmanagement.converters.LeadCreateRequestConverter;
import br.com.leadsmanagement.converters.LeadCreateResponseConverter;
import br.com.leadsmanagement.domain.Lead;
import br.com.leadsmanagement.problemdetails.ConflictException;
import br.com.leadsmanagement.request.LeadCreateRequest;
import br.com.leadsmanagement.response.LeadCreateResponse;
import br.com.leadsmanagement.services.LeadService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class LeadController {

	private final LeadService leadService;
	private final LeadCreateRequestConverter leadCreateRequestConverter;
	private final LeadCreateResponseConverter leadCreateResponseConverter;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/lead")
	@ExceptionHandler(Throwable.class)
	Mono<LeadCreateResponse> create(@RequestBody LeadCreateRequest request) {
		
		Lead lead = this.leadCreateRequestConverter.convert(request);
		
		return this.leadService.create(lead).map(response -> this.leadCreateResponseConverter.convert(response));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/lead/{id}/{status}")
	@ExceptionHandler({ConflictException.class, Throwable.class})
	Mono<Lead> finishLead(@PathVariable String id, @PathVariable String status) {		
		
		Mono<Lead> response = this.leadService.finishLead(id, status);
		
		return response;
	}
	
}
