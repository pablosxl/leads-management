package br.com.leadsmanagement.pipedrive;

import org.springframework.http.ResponseEntity;

import com.alibaba.fastjson.JSONObject;

public interface PipeDriveGateway {
	
	public JSONObject createDeal(Deal deal);
	public JSONObject createPerson(Person person);
	public JSONObject createOrganization(Organization organization);
	public JSONObject createNote(Note note);
}
