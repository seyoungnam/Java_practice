package controller;

import model.ClientModel;
import model.domain.ClientDTO;
import view.EndView;

public class ClientController {
	//2. getInstance method 결과값을 받는 instance field 만들기
	private static ClientController instance = new ClientController();
	
	//3. 현재 클래스 내 method에서 쓸 singleton instance 불러오기
	private ClientModel db = ClientModel.getInstance();
	
	//1. private 생성자 만들고 getInstance method 만들기
	private ClientController() {}
	public static ClientController getInstance() {
		return instance;
	}
	
	//static 삭제
	public void request(int num) {
		//num 1 : DB 전체 조회
		if(num == 1) {
			//DB 내 getAll 메소드를 호출하여 받은 값을 EndView의 printAll 메소드로 넘김
			EndView.printAll(db.getAll());
			
		//num 2 : 신규 회원 등록(create)	
		}else if(num == 2) {
			ClientDTO t = db.insert(view.StartView.createClient());
			if(t != null) {
				EndView.success("신규 회원 등록 성공");
				EndView.printLine(t);			
			}else {
				EndView.fail("신규 회원 등록 실패");
			}
			
		//num 3 : 회원 검색(read)
		}else if(num == 3) {
			ClientDTO t = db.search(view.StartView.nameSearch());
			if(t != null) {
				EndView.printLine(t);
			}else {
				EndView.fail("검색하신 회원이 없습니다.");
			}
			
		//num 4 : 회원 정보 수정(update)
		}else if(num == 4) {
			ClientDTO t = db.update(view.StartView.changeInfo());
			if(t != null) {
				EndView.success("회원 정보가 성공적으로 수정되었습니다.");
				EndView.printLine(t);
			}else {
				EndView.fail("회원 정보 업데이트에 실패하였습니다.");
			}
			
		//num 5 : 회원 정보 삭제(delete)	
		}else if(num == 5) {
			boolean t = db.delete(view.StartView.deleteName());
			if(t) {
				EndView.success("회원 정보 삭제에 성공하였습니다.");
			}else {
				EndView.fail("회원 정보 삭제에 실패하였습니다.");
			}
		}
	}
}
