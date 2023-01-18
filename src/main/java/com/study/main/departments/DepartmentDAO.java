package com.study.main.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.study.main.util.DBConnection;

public class DepartmentDAO {
	
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
