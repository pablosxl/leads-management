package br.com.leadsmanagement.pipedrive;

import org.bson.json.JsonObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

import br.com.leadsmanagement.config.Env;

public class PipeDriveGatewayImpl implements PipeDriveGateway {
	
	private static final String ENDPOINT_TEMPLATE = "%s%s?api_token=%s";
	private final String createDealUrl = "/deals";
	private final String createPersonUrl = "/persons";
	private final String createOrganizationUrl = "/organizations";
	private final String createNoteUrl = "/notes";
	private RestTemplate restTemplate;
	
	
	public PipeDriveGatewayImpl() {
		this.restTemplate = new RestTemplate();
		
	}
	
	private String getEndPont(String path) {
		
		return String.format(ENDPOINT_TEMPLATE, 
				Env.getInstance().getPipeDriveBaseUrl(), 
				path,
				Env.getInstance().getPipeDriveApiToken()); 
	}
	
	@Override
	public ResponseEntity<JSONObject> createDeal(Deal deal) {
		// TODO Auto-generated method stub
		
		ResponseEntity<JSONObject> response = this.restTemplate.postForEntity(this.getEndPont(createDealUrl), deal, JSONObject.class);
	
		return response;
	}

	@Override
	public ResponseEntity<JSONObject> createPerson(Person person) {
		// TODO Auto-generated method stub
		
		ResponseEntity<JSONObject> response = this.restTemplate.postForEntity(this.getEndPont(createPersonUrl), person, JSONObject.class);
	
		return response;
	}

	@Override
	public ResponseEntity<JSONObject> createOrganization(Organization organization) {
		// TODO Auto-generated method stub
		ResponseEntity<JSONObject> response = this.restTemplate.postForEntity(this.getEndPont(createOrganizationUrl), organization, JSONObject.class);
		
		return response;
	}

	@Override
	public ResponseEntity<JSONObject> createNote(Note note) {
		// TODO Auto-generated method stub
		ResponseEntity<JSONObject> response = this.restTemplate.postForEntity(this.getEndPont(createNoteUrl), note, JSONObject.class);
	
		return response;
	}


}
