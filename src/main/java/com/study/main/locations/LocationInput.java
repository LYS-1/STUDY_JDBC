package com.study.main.locations;

import java.util.Scanner;

public class LocationInput {
	private Scanner sc;
	
	public LocationInput() {
		sc = new Scanner(System.in);
	}
	public LocationDTO updateData() {
		LocationDTO loDTO = new LocationDTO();
		
		System.out.println("location_id를 입력하세요");
		loDTO.setLocation_id(sc.nextInt());
		System.out.println("street_address를 입력하세요");
		loDTO.setStreet_address(sc.next());
		System.out.println("postal_code를 입력하세요");
		loDTO.setPostal_code(sc.next());
		
		return loDTO;
		
	}
	public LocationDTO setData() {
		LocationDTO loDTO = new LocationDTO();
		
		System.out.println("street_address를 입력하세요");
		loDTO.setStreet_address(sc.next());
		System.out.println("postal_code를 입력하세요");
		loDTO.setPostal_code(sc.next());
		System.out.println("ciyt를 입력하세요");
		loDTO.setCity(sc.next());
		System.out.println("state_province를 입력하세요");
		loDTO.setState_province(sc.next());
		System.out.println("country_id를 입력하세요");
		loDTO.setCountry_id(sc.next());
		
		return loDTO;
	}
	public LocationDTO delData() {
		LocationDTO loDTO = new LocationDTO();
		
		System.out.println("삭제하려는 locaiont_id를 입력하세요");
		loDTO.setLocation_id(sc.nextInt());
		
		return loDTO;
	}
	
}
