package com.study.main.employees;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {
	private Scanner sc;
	private EmployeeDAO eDAO;
	private EmployeeDTO eDTO;
	private EmployeeView eView;
	private ArrayList<EmployeeDTO> eArr;
	private EmployeeInput eInput;
	public EmployeeController() {
		sc = new Scanner(System.in);
		eDAO = new EmployeeDAO();
		eDTO = new EmployeeDTO();
		eView = new EmployeeView();
		eArr = new ArrayList<EmployeeDTO>();
		eInput = new EmployeeInput();
	}
	
	public void start() throws Exception{
		boolean check = true;
		while(check) {
			System.out.println("1. 사원 전체 정보 리스트");
			System.out.println("2. 개별 사원 정보 검색(사원 번호)");
			System.out.println("3. 개별 사원 정보 검색(사원 last_name)");
			System.out.println("4. 사원 정보 추가");
			System.out.println("5. 사원 정보 삭제");
			System.out.println("6. 사원 정보 수정");
			System.out.println("7. 종료");
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
				eDTO = eInput.setData();
				num = EmployeeDAO.setData(eDTO);
				if(num > 0) {
					System.out.println("성공");
				}else {
					System.out.println("실패");
				}
				break;
			case 5:
				eDTO = eInput.delData();
				num = EmployeeDAO.delData(eDTO);
				if(num > 0) {
					System.out.println("성공");
				}else {
					System.out.println("실패");
				}
				break;
			case 6:
				eDTO = eInput.updateData();
				num = EmployeeDAO.updateData(eDTO);
				if(num > 0) {
					System.out.println("성공");
				}else {
					System.out.println("실패");
				}
				break;
			case 7:
				System.out.println("메인페이지 복귀");
				check = false;
				break;
			default:
				break;
			}
		}
	}
}
