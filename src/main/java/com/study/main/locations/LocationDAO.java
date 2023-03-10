package com.study.main.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.study.main.util.DBConnection;

public class LocationDAO {
	public static int updateData(LocationDTO lDTO) throws Exception{
		
		Connection con = DBConnection.getConnection();
		
		String sql = "UPDATE LOCATIONS SET STREET_ADDRESS = ?, POSTAL_CODE = ? WHERE LOCATION_ID = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, lDTO.getStreet_address());
		ps.setString(2, lDTO.getPostal_code());
		ps.setInt(3, lDTO.getLocation_id());
		
		int result = ps.executeUpdate();
		
		DBConnection.disconnect(ps, con);
		
		return result;
	}
	public static int delData(LocationDTO lDTO) throws Exception{
		
		Connection con = DBConnection.getConnection();
		
		String sql = "DELETE LOCATIONS WHERE LOCATION_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, lDTO.getLocation_id());
		
		int result = ps.executeUpdate();
		
		DBConnection.disconnect(ps, con);
		
		return result;
	}
	
	
	public static int setData(LocationDTO lDTO) throws Exception{
		
		Connection con = DBConnection.getConnection();
		
		String sql = "INSERT INTO LOCATIONS (LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID) "
				+ "VALUES (LOCATIONS_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, lDTO.getStreet_address());
		ps.setString(2, lDTO.getPostal_code());
		ps.setString(3, lDTO.getCity());
		ps.setString(4, lDTO.getState_province());
		ps.setString(5, lDTO.getCountry_id());
		
		int result = ps.executeUpdate();
		
		DBConnection.disconnect(ps, con);
		
		return result;
	}
	public static ArrayList<LocationDTO> getFind(String search) throws Exception{
		ArrayList<LocationDTO> loArr = new ArrayList<LocationDTO>();
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + search + "%");
		
		ResultSet rs = ps.executeQuery();
		
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

		
		DBConnection.disconnect(rs, ps, con);
		
		return loArr;
	}
	
	public static LocationDTO getDetail(int location_ID) throws Exception{//locations ??????????????? location_id??? ??????
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
			return null;
		}
		
		DBConnection.disconnect(rs, ps, con);
		
		return loDTO;
	}
		
	public static ArrayList<LocationDTO> getList() throws Exception{//locations ????????? ?????? ??????
		ArrayList<LocationDTO> loArr = new ArrayList<LocationDTO>();
		
		Connection con = DBConnection.getConnection();
		
		// 3. query??? ??????
		String sql = "SELECT * FROM LOCATIONS";
		
		// 4. query??? ?????? ??????
		PreparedStatement ps = con.prepareStatement(sql);
		
		// 5. ? ??????
		
		
		// 6. ?????? ?????? ??? ?????? ??????
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
		
		// 7. ?????? ??????
		DBConnection.disconnect(rs, ps, con);
		
		return loArr;
	}
}
