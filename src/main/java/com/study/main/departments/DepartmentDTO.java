package com.study.main.departments;

import java.util.ArrayList;

import com.study.main.employees.EmployeeDTO;

public class DepartmentDTO {
	//모든 멤버 변수의 접근 지정자는 private
	//멤버 변수의 데이터타입과 변수명은 테이블의 컬럼의 데이터타입과 컬럼명과 일치
	//getter setter 생성
	//생성자는 여러개 가능하지만 기본생성자는 있어야함
	private Integer department_id;
	private String department_name;
	private Integer manager_id;
	private Integer location_id;
	private ArrayList<EmployeeDTO> employeeDTOs;
	
	
	

	public ArrayList<EmployeeDTO> getEmployeeDTOs() {
		return employeeDTOs;
	}

	public void setEmployeeDTOs(ArrayList<EmployeeDTO> employeeDTOs) {
		this.employeeDTOs = employeeDTOs;
	}

	public Integer getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public Integer getManager_id() {
		return manager_id;
	}

	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}

	public Integer getLocation_id() {
		return location_id;
	}

	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}
	
	
	
}
