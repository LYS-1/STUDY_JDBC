package com.study.main.employees;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.study.main.util.DBConnection;

public class EmployeeDAO {
	
	public static ArrayList<Double> getAvg() throws Exception{
		ArrayList<Double> avg = new ArrayList<Double>();
		Connection con = DBConnection.getConnection();
		String sql = "SELECT AVG(SALARY), SUM(SALARY) FROM EMPLOYEES";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		avg.add(rs.getDouble("AVG(SALARY)"));
		avg.add(rs.getDouble("SUM(SALARY)"));

		DBConnection.disconnect(rs,ps,con);
		
		return avg;
	}
	
	public static int updateData(EmployeeDTO eDTO) throws Exception {
		
		Connection con = DBConnection.getConnection();
		
		String sql = "UPDATE EMPLOYEES SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ? WHERE EMPLOYEE_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, eDTO.getFirst_name());
		ps.setString(2, eDTO.getLast_name());
		ps.setString(3, eDTO.getEmail());
		ps.setInt(4, eDTO.getEmployee_id());
		
		int result = ps.executeUpdate();
	
		return result;
	}
	public static int delData(EmployeeDTO eDTO) throws Exception{

		Connection con = DBConnection.getConnection();
		
		String sql = "DELETE EMPLOYEES WHERE EMPLOYEE_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, eDTO.getEmployee_id());
		
		int result = ps.executeUpdate();
	
		return result;
		
	}
	
	public static int setData(EmployeeDTO eDTO) throws Exception{
		
		Connection con = DBConnection.getConnection();
		
		String sql = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID)"
				+ "VALUES (EMPLOYEES_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, eDTO.getFirst_name());
		ps.setString(2, eDTO.getLast_name());
		ps.setString(3, eDTO.getEmail());
		ps.setString(4, eDTO.getPhone_number());
		ps.setDate(5, eDTO.getHire_date());
		ps.setString(6, eDTO.getJob_id());
		ps.setDouble(7, eDTO.getSalary());
		ps.setDouble(8, eDTO.getCommission_pct());
		ps.setInt(9, eDTO.getManager_id());
		ps.setInt(10, eDTO.getDepartment_id());
		
		int result = ps.executeUpdate();
		
		return result;
		
}
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
			eDTO.setSalary(rs.getDouble("SALARY"));
			eDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			eDTO.setManager_id(rs.getInt("MANAGER_ID"));
			eDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			return eDTO;
			
		}else {
			
			return null;
			
		}
		
		
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
			eDTO.setSalary(rs.getDouble("SALARY"));
			eDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			eDTO.setManager_id(rs.getInt("MANAGER_ID"));
			eDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			eArr.add(eDTO);
		}
		
		return eArr;
	}
	
}
