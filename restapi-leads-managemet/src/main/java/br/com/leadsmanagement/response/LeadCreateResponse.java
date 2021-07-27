package br.com.leadsmanagement.response;

import java.util.ArrayList;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import br.com.leadsmanagement.domain.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadCreateResponse {
	private String id;
	private String name;
	private String company;
	private String site;
	private String email;
	private String note;
	private ArrayList<PhoneCreateResponse> phone;
	private String userId;
}
