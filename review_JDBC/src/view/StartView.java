package view;

import controller.ClientController;
import model.domain.ClientDTO;

public class StartView {
	
	//신규 회원 등록시 사용
	public static ClientDTO createClient() {
		return new ClientDTO("Kudos", "UK", 50);
	}
	//회원 검색
	public static String nameSearch() {
		return "宋佳佳";
	}
	//수정할 회원 정보
	public static ClientDTO changeInfo() {
		return new ClientDTO("Alex King", "FR", 40);
	}
	//삭제할 회원 이름
	public static String deleteName() {
		return "김삼구";
	}
	
	
	public static void main(String[] args) {
		
		//Controller singleton instance 불러오기
		ClientController controller = ClientController.getInstance();
		
		System.out.println("======== 회원 전체 명부 ========");
		controller.request(1);
		System.out.println("");

		System.out.println("======== 신규 회원 등록(Kudos) ========");
		controller.request(2);
		System.out.println("-------- 신규 등록 반영 후 회원 전체 명부 --------");
		controller.request(1);
		System.out.println("");
		
		System.out.println("======== 기존 회원 정보 검색(宋佳佳) ========");
		controller.request(3);
		System.out.println("");
		
		System.out.println("======== 회원 정보 수정(Alex King의 country와 age 정보 수정) ========");
		controller.request(4);
		System.out.println("-------- 수정 후 회원 전체 명부 --------");
		controller.request(1);
		System.out.println("");
		
		System.out.println("======== 회원 정보 삭제(김삼구 정보 삭제) ========");
		controller.request(5);
		System.out.println("-------- 삭제 후 회원 전체 명부 --------");
		controller.request(1);

	}

}
