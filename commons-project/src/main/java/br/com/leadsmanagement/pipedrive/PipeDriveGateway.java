package br.com.leadsmanagement.pipedrive;

public interface PipeDriveGateway {
	
	public void createDeal(Deal deal);
	public void createPerson(Person person);
	public void createOrganization(Organization organization);
	public void createNote(Note note);
}
