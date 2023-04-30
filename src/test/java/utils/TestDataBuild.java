package utils;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	public AddPlace addPlacePayload(String name, String website, String phone) {
		
		List<String> myList = new ArrayList<String>();
			myList.add("shoe park");
			myList.add("shop");
		Location l = new Location();
			l.setLat(-38.383494);
			l.setLng(33.427362);
		AddPlace ap = new AddPlace();
			ap.setLocation(l);
			ap.setAccuracy(50);
			ap.setName(name);
			ap.setPhone_number(phone);
			ap.setAddress("29, side layout, cohen 09");
			ap.setTypes(myList);
			ap.setWebsite(website);
			ap.setLanguage("French-IN");
			
		return ap;
		
	}
	
	public String deletePlacePayload(String id) {
		
		return "{\"place_id\":\""+id+"\"}";
		
	}
	
}
