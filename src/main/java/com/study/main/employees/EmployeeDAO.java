package com.study.main.employees;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.study.main.util.DBConnection;

public class EmployeeDAO {
	
	public ArrayList<EmployeeDTO> getList() throws Exception{
		ArrayList<EmployeeDTO> eArr = new ArrayList<EmployeeDTO>();
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, MANAGER_ID, DEPARTMENT_ID FROM EMPLOYEES ORDER BY HIRE_DATE DESC";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			EmployeeDTO eDTO = new EmployeeDTO();
			eDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			eDTO.setFirst_name(rs.getString("FIRST_NAME"));
			eDTO.setLast_name(rs.getString("LAST_NAME"));
			eDTO.setManager_id(rs.getInt("MANAGER_ID"));
			eDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			eArr.add(eDTO);
		}
		return eArr;
	}
	
	public EmployeeDTO getSearchNum(int num) throws Exception{
		EmployeeDTO eDTO = new EmployeeDTO();
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
				
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, num);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			eDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			eDTO.setFirst_name(rs.getString("FIRST_NAME"));
			eDTO.setLast_name(rs.getString("LAST_NAME"));
			eDTO.setEmail(rs.getString("EMAIL"));
			eDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			eDTO.setHire_date(rs.getDate("HIRE_DATE"));
			eDTO.setJob_id(rs.getString("JOB_ID"));
			eDTO.setSalary(rs.getInt("SALARY"));
			eDTO.setCommission_pct(rs.getInt("COMMISSION_PCT"));
			eDTO.setManager_id(rs.getInt("MANAGER_ID"));
			eDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
		}else {
			
			eDTO = null;
			
		}
		
		return eDTO;
	}
	
	public ArrayList<EmployeeDTO> getSearchLastName(String name) throws Exception{
		ArrayList<EmployeeDTO> eArr = new ArrayList<EmployeeDTO>();
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + name + "%");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			EmployeeDTO eDTO = new EmployeeDTO();
			
			eDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			eDTO.setFirst_name(rs.getString("FIRST_NAME"));
			eDTO.setLast_name(rs.getString("LAST_NAME"));
			eDTO.setEmail(rs.getString("EMAIL"));
			eDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			eDTO.setHire_date(rs.getDate("HIRE_DATE"));
			eDTO.setJob_id(rs.getString("JOB_ID"));
			eDTO.setSalary(rs.getInt("SALARY"));
			eDTO.setCommission_pct(rs.getInt("COMMISSION_PCT"));
			eDTO.setManager_id(rs.getInt("MANAGER_ID"));
			eDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			eArr.add(eDTO);
		}
		
		return eArr;
	}
	
}
