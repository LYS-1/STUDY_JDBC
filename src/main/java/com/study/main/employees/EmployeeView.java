package com.study.main.employees;

import java.util.ArrayList;

public class EmployeeView {
	public void view(ArrayList<EmployeeDTO> eArr, int num) {
		if(num == 1) {
			for(EmployeeDTO eDTO : eArr) {
				
				System.out.println("employee_id : " + eDTO.getEmployee_id());
				System.out.println("first_name : " + eDTO.getFirst_name());
				System.out.println("last_name : " + eDTO.getLast_name());
				System.out.println("manager_id : " + eDTO.getManager_id());
				System.out.println("department_id : " + eDTO.getDepartment_id());
				System.out.println("=========================");
				
			}
		}else {
			for(EmployeeDTO eDTO : eArr) {
				this.view(eDTO);
				System.out.println("=========================");
			}
		}
	}
	
	public void view(EmployeeDTO eDTO) {
		System.out.println("employee_id : " + eDTO.getEmployee_id());
		System.out.println("first_name : " + eDTO.getFirst_name());
		System.out.println("last_name : " + eDTO.getLast_name());
		System.out.println("email : " + eDTO.getEmail());
		System.out.println("phone_number : " + eDTO.getPhone_number());
		System.out.println("hire_date : " + eDTO.getHire_date());
		System.out.println("job_id : " + eDTO.getJob_id());
		System.out.println("salary : " + eDTO.getSalary());
		System.out.println("commision_pct : " + eDTO.getCommission_pct());
		System.out.println("manager_id : " + eDTO.getManager_id());
		System.out.println("department_id : " + eDTO.getDepartment_id());
	}
	
	public void view(String str) {
		System.out.println(str);
	}
}
