package com.study.main;


public class JDBCMain {
	public static void main(String[] args) {
		System.out.println("start");
		
		MainController mc = new MainController();
		
		try {
			mc.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("finish");
	}
}
