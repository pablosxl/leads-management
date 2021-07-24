package br.com.leadsmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lead {
	private int id;
	private String name;
	private String company;
	private String site;
	private String status;
	private Phone phone;
	private int userId;
	
}
