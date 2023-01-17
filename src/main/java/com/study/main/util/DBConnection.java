package com.study.main.util;

import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	public void getConnection() throws Exception{
		//1. id
		String username = "hr";
		//2. password
		String password = "hr";
		//3. ip,portnum(url)
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		//4. DRIVER
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		String sql = "SELECT * FROM REGIONS WHERE REGION_ID = 2";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString("REGION_ID") + " : " + rs.getString("REGION_NAME"));
		}
	}
}
