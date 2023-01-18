package com.study.main;

import java.util.Scanner;

import com.study.main.departments.DepartmentController;
import com.study.main.employees.EmployeeController;
import com.study.main.locations.LocationController;

public class MainController {
	private Scanner sc;
	private DepartmentController dc;
	private LocationController lc;
	private EmployeeController ec;
	public MainController() {
		
		sc = new Scanner(System.in);
		
		dc = new DepartmentController();
		
		lc = new LocationController();
		
		ec = new EmployeeController();
		
	}
	
	public void start() throws Exception{
		
		boolean check = true;
		
		while(check) {
			System.out.println("메인 페이지");
			System.out.println("1. 부서 정보 검색");
			System.out.println("2. 지역 정보 검색");
			System.out.println("3. 사원 정보 검색");
			System.out.println("4. 종료");
			
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				System.out.println("부서 정보 검색 시작");
				dc.start();
				break;
			case 2:
				System.out.println("지역 정보 검색 시작");
				lc.start();
				break;
			case 3:
				System.out.println("사원 정보 검색 시작");
				ec.start();
				break;
			case 4:
				check = false;
				break;
			default:
				System.out.println("잘못된 번호");
				break;
			}
		}
	}
}	
