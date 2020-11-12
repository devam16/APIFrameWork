package resources;

public enum APIResources {
	
	AddPetAPI("/v2/pet"),
	DeletePetAPI("/v2/pet/{pet}"),
	GetPetByStatusAPI("/v2/pet/findByStatus"),
	GetPetByIDAPI("/v2/pet/{id}"),
	UpdatePetAPI("/v2/pet");
	
	private String resource;
	
	APIResources(String resource) {
		
		this.resource=resource;
	}
	
	public String getAPIResource() {
		
		return resource;
	}

}
