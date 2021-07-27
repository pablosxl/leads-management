package br.com.leadsmanagement.converters;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.leadsmanagement.domain.Lead;
import br.com.leadsmanagement.domain.LeadStatusEnum;
import br.com.leadsmanagement.domain.Phone;
import br.com.leadsmanagement.request.LeadCreateRequest;

@Component
public class LeadCreateRequestConverter implements Converter<LeadCreateRequest, Lead> {

	@Override
	public Lead convert(LeadCreateRequest request) {
		// TODO Auto-generated method stub
		return new Lead(
				null, 
				request.getName(), 
				request.getCompany(), 
				request.getSite(), 
				request.getEmail(),
				request.getNote(),
				LeadStatusEnum.OPEN.getDescription(), this.addPhone(request.getPhone()), 
				new ObjectId(request.getUserId()));
	}
	
	private List<Phone> addPhone(String[] numbers) {
		
		List<Phone> phoneList = new ArrayList<Phone>();
		
		if(numbers != null) {
			for(String item : numbers) {
				phoneList.add(new Phone(null,null,item));
				
			}
		}
		
		return phoneList;
	}
	
}
