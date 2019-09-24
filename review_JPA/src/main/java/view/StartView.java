package view;

import java.util.ArrayList;
import java.util.List;

import controller.ClientController;
import model.domain.ClientDTO;
import model.util.DBUtil;

public class StartView {

	//기본 회원 정보의 DB 등록시 사용
	public static List<ClientDTO> inputInfo(){
		List<ClientDTO> info = new ArrayList<ClientDTO>();
		info.add(new ClientDTO("Alex King", "US", 30));
		info.add(new ClientDTO("김삼구", "KR", 29));
		info.add(new ClientDTO("宋佳佳", "CN", 28));
		return info;
	}
	
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
		// Factory 실행
		DBUtil.runFactory();
		try {
			//Controller singleton instance 불러오기
			ClientController controller = ClientController.getInstance();
			//create
			System.out.println("======== 0. 기본 회원 명부 생성 ========");
			controller.request(0);
			System.out.println("0. 끝");
			
			//여기서부터 none
//			System.out.println("======== 1. 회원 전체 명부 ========");
//			controller.request(1);
//			System.out.println("1. 끝");
//
//			System.out.println("======== 2. 신규 회원 등록(Kudos) ========");
//			controller.request(2);
//			System.out.println("-------- 신규 등록 반영 후 회원 전체 명부 --------");
//			controller.request(1);
//			System.out.println("2. 끝");
//			
//			System.out.println("======== 3. 기존 회원 정보 검색(宋佳佳) ========");
//			controller.request(3);
//			System.out.println(" 3. 끝");
//			
//			System.out.println("======== 4. 회원 정보 수정(Alex King의 country와 age 정보 수정) ========");
//			controller.request(4);
//			System.out.println("-------- 수정 후 회원 전체 명부 --------");
//			controller.request(1);
//			System.out.println("4. 끝");
//			
//			System.out.println("======== 5. 회원 정보 삭제(김삼구 정보 삭제) ========");
//			controller.request(5);
//			System.out.println("-------- 삭제 후 회원 전체 명부 --------");
//			controller.request(1);
//			System.out.println("5. 끝");
			
		}finally { //Factory 반환
			DBUtil.closeFactory();
		}
		
		
		

	}

}
