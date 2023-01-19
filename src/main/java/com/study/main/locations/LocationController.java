package com.study.main.locations;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {
	private Scanner sc;
	private ArrayList<LocationDTO> loArr = null;
	private LocationDTO loDTO;
	private LocationView loView;
	private LocationInput loInput;
	public LocationController(){
		
		sc = new Scanner(System.in);
		
		loView = new LocationView();
		
		loDTO = new LocationDTO();
		
		loInput = new LocationInput();
	}
	
	public void start() throws Exception{
		
		boolean check = true;
		
		while(check) {
			System.out.println("1. 지역 전체 정보");
			System.out.println("2. 지역 세부 정보(지역 번호");
			System.out.println("3. 지역 정보 검색(지역 이름)");
			System.out.println("4. 지역 정보 추가");
			System.out.println("5. 지역 정보 삭제");
			System.out.println("6. 지역 정보 수정");
			System.out.println("7. 종료");
			
			int num = sc.nextInt();
			
			switch(num){
			case 1:
				loArr = LocationDAO.getList();
				loView.view(loArr);
				break;
			case 2:
				System.out.println("지역 번호 입력");
				num = sc.nextInt();
				loDTO = LocationDAO.getDetail(num);
				loView.view(loDTO);
				break;
			case 3:
				System.out.println("지역 이름 입력");
				String str = sc.next();
				loArr = LocationDAO.getFind(str);
				loView.view(loArr);
				break;
			case 4:
				loDTO = loInput.setData();
				num = LocationDAO.setData(loDTO);
				if(num > 0) {
					System.out.println("성공");
				}else {
					System.out.println("실패");
				}
				break;
			case 5:
				loDTO = loInput.delData();
				num = LocationDAO.delData(loDTO);
				if(num > 0) {
					System.out.println("성공");
				}else {
					System.out.println("실패");
				}
				break;
			case 6:
				loDTO = loInput.updateData();
				num = LocationDAO.updateData(loDTO);
				if(num > 0) {
					System.out.println("성공");
				}else {
					System.out.println("실패");
				}
				break;
			case 7:
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
