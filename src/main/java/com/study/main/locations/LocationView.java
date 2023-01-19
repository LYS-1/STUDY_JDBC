package com.study.main.locations;

import java.util.ArrayList;


public class LocationView {
	
	public void view(LocationDTO loDTO) {
		
		if(loDTO != null) {
			System.out.println("id : " + loDTO.getLocation_id());
			
			System.out.println("address : " + loDTO.getStreet_address());
				
			System.out.println("postal code : " + loDTO.getPostal_code());
				
			System.out.println("city : " + loDTO.getCity());
				
			System.out.println("state province : " + loDTO.getState_province());
				
			System.out.println("country id : " + loDTO.getCountry_id());
		}else {
			System.out.println("no data");
		}
			
	}
	
	public void view(ArrayList<LocationDTO> loArr) {
		if(loArr.size() != 0) {
			for(LocationDTO loDTO : loArr) {
				this.view(loDTO);
				System.out.println("==============================");
			}
		}else {
			System.out.println("no data");
		}
		
		
	}
	
	
	
}
