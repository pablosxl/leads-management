package br.com.leadsmanagement.request;

import br.com.leadsmanagement.domain.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class LeadCreateRequest {
	
	@NotEmpty(message = "O Nome não pode ser nulo")
	private String name;
	
	@NotEmpty(message = "é necessário informar a empresa")
	private String company;
	
	@NotEmpty(message = "é necessário informar o site")
	private String site;
	
	@NotEmpty(message = "é necessário informar um telefone")
	private Phone phone;
	
	@NotEmpty(message = "é necessário informar o id do usário")
	private int userId;
}
