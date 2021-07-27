package br.com.leadsmanagement.services;

import br.com.leadsmanagement.domain.Lead;
import reactor.core.publisher.Mono;

public interface LeadService {
	
	public Mono<Lead> create(final Lead lead);
	
	public Mono<Void> finishLead(final String id);
}
