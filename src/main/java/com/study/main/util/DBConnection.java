package com.study.main.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	public static Connection getConnection() throws Exception{
		//1. 접속 정보 준비
		//-1. id
		String username = "hr";
		//-2. password
		String password = "hr";
		//-3. ip,portnum(url) sid = "jdbc:oracle:thin:@localhost:1521:sid"
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1"; // = servicename
		//-4. DRIVER
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		//2. db접속실행
		Connection con = DriverManager.getConnection(url, username, password);
		
		return con;
		
	}
	public static void disconnect(ResultSet rs, PreparedStatement ps, Connection con) throws Exception{
		rs.close();
		ps.close();
		con.close();	
	}
	
}
