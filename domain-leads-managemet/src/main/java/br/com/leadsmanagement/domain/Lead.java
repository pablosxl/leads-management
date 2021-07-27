package br.com.leadsmanagement.domain;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "lead")
public class Lead {
	
	@Id
	private ObjectId _id;
	private String name;
	private String company;
	private String site;
	private String email;
	private String note;
	private String status;
	
	
	private List<Phone> phone;
	
	@Indexed
	private ObjectId userId;
	
}
