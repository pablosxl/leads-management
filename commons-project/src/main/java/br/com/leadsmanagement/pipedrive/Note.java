package br.com.leadsmanagement.pipedrive;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Note {
	
	private String content;
	private int deal_id;
	
}
