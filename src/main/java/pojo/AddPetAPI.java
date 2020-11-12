package pojo;

import java.util.List;


public class AddPetAPI {
	
	private double id;
	private String name;
	private String status;
	private List <String> photoUrls;
	private List<tags> tags;
	private category category;
	
	public double getId() {
		return id;
	}
	public void setId(double d) {
		this.id = d;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public List<tags> getTags() {
		return tags;
	}
	public void setTags(List<tags> tags) {
		this.tags = tags;
	}
	public category getCategory() {
		return category;
	}
	public void setCategory(category category) {
		this.category = category;
	}
	

}
