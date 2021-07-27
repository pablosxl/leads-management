package br.com.leadsmanagement.pipedrive;

import org.bson.json.JsonObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
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
	public JSONObject createDeal(Deal deal) {
		// TODO Auto-generated method stub
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("title", deal.getTitle());
		requestBody.add("currency", "USD");
		requestBody.add("org_id", Integer.toString(deal.getOrg_id()));
		requestBody.add("status", deal.getStatus());
		
		HttpEntity formEntity = new HttpEntity<MultiValueMap<String, String>>(requestBody, headers);
		
		ResponseEntity<String> response = this.restTemplate.postForEntity(this.getEndPont(createDealUrl), formEntity, String.class);
		
		JSONObject json = JSONObject.parseObject(response.getBody());
		
		return json.getJSONObject("data");
	}

	@Override
	public JSONObject createPerson(Person person) {
		// TODO Auto-generated method stub
		
		ResponseEntity<String> response = this.restTemplate.postForEntity(this.getEndPont(createPersonUrl), person, String.class);
	
		JSONObject json = JSONObject.parseObject(response.getBody());
		
		return json.getJSONObject("data");
	}

	@Override
	public JSONObject createOrganization(Organization organization) {
		// TODO Auto-generated method stub
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("name", organization.getName());
		    
		HttpEntity formEntity = new HttpEntity<MultiValueMap<String, String>>(requestBody, headers);
		
		ResponseEntity<String> response = this.restTemplate.postForEntity(this.getEndPont(createOrganizationUrl), formEntity, String.class);
		
		JSONObject json = JSONObject.parseObject(response.getBody());
		
		return json.getJSONObject("data");
	}

	@Override
	public JSONObject createNote(Note note) {
		// TODO Auto-generated method stub
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("content", note.getContent());
		requestBody.add("deal_id", Integer.toString(note.getDeal_id()));
		    
		HttpEntity formEntity = new HttpEntity<MultiValueMap<String, String>>(requestBody, headers);
		ResponseEntity<String> response = this.restTemplate.postForEntity(this.getEndPont(createNoteUrl), formEntity, String.class);
	
		JSONObject json = JSONObject.parseObject(response.getBody());
		
		return json.getJSONObject("data");
	}


}
