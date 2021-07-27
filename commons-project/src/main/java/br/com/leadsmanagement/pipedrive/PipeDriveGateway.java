package br.com.leadsmanagement.pipedrive;

import org.springframework.http.ResponseEntity;

import com.alibaba.fastjson.JSONObject;

public interface PipeDriveGateway {
	
	public ResponseEntity<JSONObject> createDeal(Deal deal);
	public ResponseEntity<JSONObject> createPerson(Person person);
	public ResponseEntity<JSONObject> createOrganization(Organization organization);
	public ResponseEntity<JSONObject> createNote(Note note);
}
