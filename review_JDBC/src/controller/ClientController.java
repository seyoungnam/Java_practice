package controller;

import model.ClientService;
import model.domain.ClientDTO;
import view.EndView;

public class ClientController {
	//Singleton 생성
	private static ClientController instance = new ClientController();
	private ClientController() {}
	public static ClientController getInstance() {
		return instance;
	}
	//service singleton 불러오기
	private static ClientService service = ClientService.getInstance();
	
	//1. private 생성자 만들고 getInstance method 만들기
	
	
	//static 삭제
	public void request(int num) {
		//num 1 : DB 전체 조회
		if(num == 1) {
			EndView.printAll(service.getAllInfo());
			
		//num 2 : 신규 회원 등록(create)	
		}else if(num == 2) {
			boolean t = service.addInfo(view.StartView.createClient());
			if(t != false) {
				EndView.success("신규 회원 등록 성공");			
			}else {
				EndView.fail("신규 회원 등록 실패");
			}
			
		//num 3 : 회원 검색(read)
		}else if(num == 3) {
			ClientDTO t = service.getInfo(view.StartView.nameSearch());
			if(t != null) {
				EndView.printLine(t);
			}else {
				EndView.fail("검색하신 회원이 없습니다.");
			}
			
		//num 4 : 회원 정보 수정(update)
		}else if(num == 4) {
			boolean t = service.updateInfo(view.StartView.changeInfo());
			if(t != false) {
				EndView.success("회원 정보가 성공적으로 수정되었습니다.");
			}else {
				EndView.fail("회원 정보 업데이트에 실패하였습니다.");
			}
			
		//num 5 : 회원 정보 삭제(delete)	
		}else if(num == 5) {
			boolean t = service.deleteInfo(view.StartView.deleteName());
			if(t) {
				EndView.success("회원 정보 삭제에 성공하였습니다.");
			}else {
				EndView.fail("회원 정보 삭제에 실패하였습니다.");
			}
		}
	}
}
