package com.study.main.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.study.main.employees.EmployeeDTO;
import com.study.main.util.DBConnection;

public class DepartmentDAO {
	
	public DepartmentDTO getInfos() throws Exception{
		DepartmentDTO departmentDTO = new DepartmentDTO();
		
		Connection con = DBConnection.getConnection();
		//30번 부서에 근무하는 사원들의 이름과 부서명
		String sql = "SELECT E.FIRST_NAME, D.DEPARTMENT_NAME"
				+ "FROM EMPLOYEES E "
				+ "INNER JOIN "
				+ "DEPARTMENTS E "
				+ "ON (E.DEPARTMENT_ID = D.DEPARTMENT_ID) "
				+ "WHERE DEPARTMENT_ID = 30;";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			if(departmentDTO.getDepartment_name() != null) {
				departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			}
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			departmentDTO.getEmployeeDTOs().add(employeeDTO);
		}
		
		return departmentDTO;
	}
	
	//JOIN
	public DepartmentDTO getInfo() throws Exception{
		DepartmentDTO departmentDTO = null;
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT E.FRIST_NAME, D.DEPLARTMENT_NAME "
				+ "FROM EMPLOYEES E "
				+ "INNER JOIN "
				+ "DEPARTMENTS D"
				+ "ON(E.DEPARTMENT_ID = D.DEPARTMENT_ID) "
				+ "WHERE E.EMPLOYEE_ID = 100";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			departmentDTO.getEmployeeDTOs().add(employeeDTO);
		}
		
		return departmentDTO;
		
	}
	
	
	public static int updateData(DepartmentDTO deDTO) throws Exception{
		
		Connection con = DBConnection.getConnection();
		//바꿀 컬럼, 바꿀 값 / departmentid = id값
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME = ? ,MANAGER_ID = ? LOCATION_ID = ?"
				+ "WHERE DEPARTMENT_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, deDTO.getDepartment_name());
		ps.setInt(2, deDTO.getManager_id());
		ps.setInt(3, deDTO.getLocation_id());
		ps.setInt(4, deDTO.getDepartment_id());
		int result = ps.executeUpdate();
		
		DBConnection.disconnect(ps, con);
		
		return result;
	}
	public static int delData(DepartmentDTO deDTO) throws Exception{
		
		Connection con = DBConnection.getConnection();
		
		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, deDTO.getDepartment_id());
		
		int result = ps.executeUpdate();
		
		DBConnection.disconnect(ps, con);
		
		return result;
	}
	
	public static int setData(DepartmentDTO deDTO) throws Exception{
		
		Connection con = DBConnection.getConnection();
		
		String sql = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) "
				+ "VALUES(DEPARTMENTS_SEQ.NEXTVAL, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1,	deDTO.getDepartment_name());
		ps.setInt(2, deDTO.getManager_id());
		ps.setInt(3, deDTO.getLocation_id());
		
		int result = ps.executeUpdate();
		
		DBConnection.disconnect(ps, con);
		
		return result;
		
	}
	
	public static DepartmentDTO getDetail(int department_id) throws Exception{
		DepartmentDTO deDTO = null;
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, department_id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			deDTO = new DepartmentDTO();
			deDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			deDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			deDTO.setLocation_id(rs.getInt("MANAGER_ID"));
			deDTO.setLocation_id(rs.getInt("LOCATION_ID"));
		}else {
			System.out.println("no data");
		}
		
		DBConnection.disconnect(rs, ps, con);
		
		return deDTO;
	}
	
	public static ArrayList<DepartmentDTO> getList() throws Exception{
		
		ArrayList<DepartmentDTO> deArr = new ArrayList<DepartmentDTO>();
		
		Connection con = DBConnection.getConnection();
		
		// 3. query문 생성
		String sql = "SELECT * FROM DEPARTMENTS";
		
		// 4. query문 미리 전송
		PreparedStatement ps = con.prepareStatement(sql);
		
		// 5. ? 세팅
		
		// 6. 최종 전송 및 결과 처리
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			DepartmentDTO deDTO = new DepartmentDTO();
			
			deDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			deDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			deDTO.setManager_id(rs.getInt("MANAGER_ID"));
			deDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			
			deArr.add(deDTO);
			
		}
		
		// 7. 연결 해제
		DBConnection.disconnect(rs, ps, con);
		
		return deArr;
	}
}
