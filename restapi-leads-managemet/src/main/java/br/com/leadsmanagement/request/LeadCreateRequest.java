package br.com.leadsmanagement.request;

import br.com.leadsmanagement.domain.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class LeadCreateRequest {
	
	@NotEmpty(message = "O Nome não pode ser nulo")
	private String name;
	
	@NotEmpty(message = "é necessário informar a empresa")
	private String company;
	
	@NotEmpty(message = "é necessário informar o site")
	private String site;
	
	@NotEmpty(message = "é necessário informar o email")
	@Email(message = "email inválido")
	private String email;
	
	
	private String note;
	
	@NotEmpty(message = "é necessário informar um telefone")
	private String[] phone;
	
	@NotEmpty(message = "é necessário informar o id do usário")
	private String userId;
}
