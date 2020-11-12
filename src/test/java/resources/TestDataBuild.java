package resources;

import java.util.ArrayList;

import pojo.AddPetAPI;
import pojo.category;
import pojo.tags;

public class TestDataBuild {
	
	
	public static AddPetAPI addPetPayload(String petName,String toStatus) {
		
		AddPetAPI apa=new AddPetAPI();
		category cat=new category();
		ArrayList<String> photoUrls=new ArrayList<String>();
		photoUrls.add("string");
		ArrayList<tags> tag=new ArrayList<tags>();
		tags t=new tags();
		t.setId(0);
		t.setName("string");
		tag.add(t);
		cat.setId(0);
		cat.setName("string");
		apa.setId(0);
		apa.setCategory(cat);
		apa.setName(petName);
		apa.setPhotoUrls(photoUrls);
		apa.setTags(tag);
		apa.setStatus(toStatus);
		return apa;
		
	}
	

public static AddPetAPI addPetPayload(String place_id,String petName,String toStatus) {
	
	AddPetAPI apa=new AddPetAPI();
	category cat=new category();
	ArrayList<String> photoUrls=new ArrayList<String>();
	photoUrls.add("string");
	ArrayList<tags> tag=new ArrayList<tags>();
	tags t=new tags();
	t.setId(0);
	t.setName("string");
	tag.add(t);
	cat.setId(0);
	cat.setName("string");
	apa.setId(Double.parseDouble(place_id));
	apa.setCategory(cat);
	apa.setName(petName);
	apa.setPhotoUrls(photoUrls);
	apa.setTags(tag);
	apa.setStatus(toStatus);
	return apa;
	
}

}
