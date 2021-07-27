package br.com.leadsmanagement.pipedrive;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Deal {
	private String title;
	private String currency;
	private int org_id;
}
