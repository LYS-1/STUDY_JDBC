package com.study.main;

import com.study.main.util.DBConnection;

public class JDBCMain {
	public static void main(String[] args) {
		System.out.println("start");
		
		DBConnection con = new DBConnection();
		try {
			con.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("finish");
	}
}
