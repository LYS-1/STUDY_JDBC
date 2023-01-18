package com.study.main.employees;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {
	private Scanner sc;
	private EmployeeDAO eDAO;
	private EmployeeDTO eDTO;
	private EmployeeView eView;
	private ArrayList<EmployeeDTO> eArr;
	public EmployeeController() {
		sc = new Scanner(System.in);
		eDAO = new EmployeeDAO();
		eDTO = new EmployeeDTO();
		eView = new EmployeeView();
		eArr = new ArrayList<EmployeeDTO>();
	}
	
	public void start() throws Exception{
		boolean check = true;
		while(check) {
			System.out.println("1. 사원 전체 정보 리스트");
			System.out.println("2. 개별 사원 정보 검색(사원 번호)");
			System.out.println("3. 개별 사원 정보 검색(사원 last_name)");
			System.out.println("4. 종료");
			int num = sc.nextInt();
			
			switch (num) {
			case 1:
				eArr = eDAO.getList();
				eView.view(eArr, num);
				break;
			case 2:
				System.out.println("검색할 사원 번호를 입력하세요.");
				num = sc.nextInt();
				eDTO = eDAO.getSearchNum(num);
				eView.view(eDTO);
				break;
			case 3:
				System.out.println("검색할 사원의 이름을 입력하세요.");
				String str = sc.next();
				eArr = eDAO.getSearchLastName(str);
				eView.view(eArr, num);
				break;
			case 4:
				System.out.println("메인페이지 복귀");
				check = false;
				break;
			default:
				break;
			}
		}
	}
}
