package br.com.leadsmanagement.mongodb;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.data.mongodb")
public final class MongoProperties {
	
	private String uri;
	
	
	public MongoProperties(String uri) {
		this.uri = uri;
	}
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
	
	
}
