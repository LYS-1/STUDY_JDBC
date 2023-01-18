package com.study.main.departments;

import java.util.ArrayList;

public class DepartmentView {
	public void view(DepartmentDTO deDTO) {
		
		System.out.println("id : " + deDTO.getDepartment_id());
			
		System.out.println("name : " + deDTO.getDepartment_name());
			
		System.out.println("location id : " + deDTO.getLocation_id());
			
		System.out.println("manager id : " + deDTO.getManager_id());
		
	}
	
	public void view(ArrayList<DepartmentDTO> deArr) {
//		for(int i = 0; i < deArr.size(); i++) {
//			System.out.println("id : " + deArr.get(i).getDepartment_id());
//			
//			System.out.println("name : " + deArr.get(i).getDepartment_name());
//			
//			System.out.println("location id : " + deArr.get(i).getLocation_id());
//			
//			System.out.println("manager id : " + deArr.get(i).getManager_id());
//			
//			System.out.println("==============================");
//		}
		for(DepartmentDTO deDTO : deArr) {
			this.view(deDTO);
		}
	}
	
}
