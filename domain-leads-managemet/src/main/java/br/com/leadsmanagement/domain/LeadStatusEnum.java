package br.com.leadsmanagement.domain;

public enum LeadStatusEnum {
	
	OPEN(1, "OPEN", true),
	WON(2, "WON", true),
	LOST(3, "LOST", true);
	
	private Integer domainId;
	private String description;
	private boolean active;
	
	private LeadStatusEnum(int domainId, String description, boolean active) {
		this.domainId = domainId;
		this.description = description;
		this.active = active;
	}

	public int getDomainId() {
		return domainId;
	}

	public void setDomainId(int domainId) {
		this.domainId = domainId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
