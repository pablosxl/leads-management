package br.com.leadsmanagement.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "phone")
public class Phone {
	
	@Id
	private ObjectId _id;
	
	@Indexed
	private ObjectId leadId;
	private String number;
}
