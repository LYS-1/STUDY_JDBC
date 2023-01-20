package com.study.main.employees;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class EmployeeInput {
	private Scanner sc;
	
	public EmployeeInput() {
		sc = new Scanner(System.in);
	}
	
	public EmployeeDTO setData() {
		EmployeeDTO eDTO = new EmployeeDTO();
		System.out.println("first_name을 입력하세요");
		eDTO.setFirst_name(sc.next());
		System.out.println("last_name을 입력하세요");
		eDTO.setLast_name(sc.next());
		System.out.println("email을 입력하세요");
		eDTO.setEmail(sc.next());
		System.out.println("phone_number를 입력하세요");
		eDTO.setPhone_number(sc.next());
		System.out.println("hire_date를 입력하세요. (형식: yyyy-mm-dd)");
		eDTO.setHire_date(sc.next());
		System.out.println("job_id를 입력하세요");
		eDTO.setJob_id(sc.next());
		System.out.println("salary를 입력하세요");
		eDTO.setSalary(sc.nextDouble());
		System.out.println("commission_pct를 입력하세요");
		eDTO.setCommission_pct(sc.nextDouble());
		System.out.println("manager_id를 입력하세요");
		eDTO.setManager_id(sc.nextInt());
		System.out.println("department_id를 입력하세요");
		eDTO.setDepartment_id(sc.nextInt());
		return eDTO;
	}
	
	public EmployeeDTO delData() {
		EmployeeDTO eDTO = new EmployeeDTO();
		System.out.println("삭제할 employee_id 입력");
		eDTO.setEmployee_id(sc.nextInt());
		return eDTO;
	}
	public EmployeeDTO updateData() {
		EmployeeDTO eDTO = new EmployeeDTO();
		
		System.out.println("수정할 employee_id 입력");
		eDTO.setEmployee_id(sc.nextInt());
		System.out.println("수정할 first_name 입력");
		eDTO.setFirst_name(sc.next());
		System.out.println("수정할 last_name 입력");
		eDTO.setLast_name(sc.next());
		System.out.println("수정할 email 입력");
		eDTO.setEmail(sc.next());
		
		return eDTO;
	}
}
