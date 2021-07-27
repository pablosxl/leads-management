package br.com.leadsmanagement.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.leadsmanagement.domain.Lead;
import br.com.leadsmanagement.domain.Phone;
import br.com.leadsmanagement.request.LeadCreateRequest;
import br.com.leadsmanagement.response.LeadCreateResponse;
import br.com.leadsmanagement.response.PhoneCreateResponse;

@Component
public class LeadCreateResponseConverter  implements Converter<Lead, LeadCreateResponse>{

	@Override
	public LeadCreateResponse convert(Lead lead) {
		// TODO Auto-generated method stub
		return new LeadCreateResponse(
				lead.get_id().toHexString(),
				lead.getName(), 
				lead.getCompany(), 
				lead.getSite(), 
				lead.getEmail(), 
				lead.getNote(), 
				this.getListPhone(lead.getPhone()),
				lead.getUserId().toHexString());
	}
	
	private ArrayList<PhoneCreateResponse> getListPhone(List<Phone> phones) {
		ArrayList<PhoneCreateResponse> responseList = new ArrayList<PhoneCreateResponse>();
		
		if(!phones.isEmpty()) {
			phones.forEach(item -> {
				
				responseList.add(new PhoneCreateResponse(
						item.getNumber()));
			});
		}
		
		return responseList;
		
	}

}
