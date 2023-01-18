package com.study.main.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.study.main.util.DBConnection;

public class LocationDAO {
	
	public static ArrayList<LocationDTO> getFind(String search) throws Exception{
		ArrayList<LocationDTO> loArr = new ArrayList<LocationDTO>();
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + search + "%");
		
		ResultSet rs = ps.executeQuery();
		if(!rs.next()) {
			loArr = null;
		}
		while(rs.next()) {
			LocationDTO loDTO = new LocationDTO();
			loDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			loDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			loDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			loDTO.setCity(rs.getString("CITY"));
			loDTO.setState_province(rs.getString("STATE_PROVINCE"));
			loDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			
			loArr.add(loDTO);
		}
		
		return loArr;
	}
	
	public static LocationDTO getDetail(int location_ID) throws Exception{//locations 테이블에서 location_id로 검색
		LocationDTO loDTO = new LocationDTO();
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, location_ID);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			
			loDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			loDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			loDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			loDTO.setCity(rs.getString("CITY"));
			loDTO.setState_province(rs.getString("STATE_PROVINCE"));
			loDTO.setCountry_id(rs.getString("COUNTRY_ID"));
		}else {
			System.out.println("no data");
		}
		
		DBConnection.disconnect(rs, ps, con);
		
		return loDTO;
	}
		
	public static ArrayList<LocationDTO> getList() throws Exception{//locations 테이블 전체 출력
		ArrayList<LocationDTO> loArr = new ArrayList<LocationDTO>();
		
		Connection con = DBConnection.getConnection();
		
		// 3. query문 생성
		String sql = "SELECT * FROM LOCATIONS";
		
		// 4. query문 미리 전송
		PreparedStatement ps = con.prepareStatement(sql);
		
		// 5. ? 세팅
		
		
		// 6. 최종 전송 및 결과 처리
		ResultSet rs = ps.executeQuery();
		
		if(!rs.next()) {
			loArr = null;
		}
		
		while(rs.next()) {
			LocationDTO loDTO = new LocationDTO();
			loDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			loDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			loDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			loDTO.setCity(rs.getString("CITY"));
			loDTO.setState_province(rs.getString("STATE_PROVINCE"));
			loDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			
			loArr.add(loDTO);
		}
		
		// 7. 연결 해제
		DBConnection.disconnect(rs, ps, con);
		
		return loArr;
	}
}
