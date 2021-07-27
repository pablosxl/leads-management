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

	public String getDescription() {
		return description;
	}

	public boolean isActive() {
		return active;
	}
	
	public final static String getDescriptionByName(final String name) {

		for (final LeadStatusEnum leadStatusEnum : LeadStatusEnum.values()) {
			if (leadStatusEnum.getDescription().equals(name.toUpperCase())) {
				return leadStatusEnum.getDescription();
			}
		}

		return null;
	}

	
	
}
