package com.study.main.departments;

import java.util.ArrayList;
import java.util.Scanner;

public class DepartmentController {
	private Scanner sc;
	private ArrayList<DepartmentDTO> deArr = null;
	private DepartmentDTO deDTO = null;
	private DepartmentView deView;
	public DepartmentController() {
		
		sc = new Scanner(System.in);
		
		deView = new DepartmentView();
	}
	
	public void start() throws Exception{
		
		boolean check = true;
		
		while(check) {
			System.out.println("1. 부서 전체 정보");
			System.out.println("2. 부서 상세 정보");
			System.out.println("3. 종료");
			
			int num = sc.nextInt();
			
			
			switch (num) {
			case 1:
				deArr = DepartmentDAO.getList();
				deView.view(deArr);
				break;
			case 2:
				System.out.println("부서 번호 입력");
				num = sc.nextInt();
				deDTO = DepartmentDAO.getDetail(num);
				deView.view(deDTO);
				break;
			case 3:
				System.out.println("메인페이지로 복귀");
				check = false;
				break;
			default:
				System.out.println("잘못된 번호");
				break;
			}
		}		
	}
}
