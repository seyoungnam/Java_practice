package view;

import java.util.List;

import model.domain.ClientDTO;

public class EndView {
	
	//전체 DB 내용 출력
	public static void printAll(List<ClientDTO> all) {
		for(ClientDTO v : all) {
			if(v != null) {
				System.out.println(v.toString());
			}
		}
	}
	
	//개별 회원 정보 출력
	public static void printLine(ClientDTO line) {
		if(line != null) {
			System.out.println(line.toString());
		}	
	}
	
	//정상 response시 출력 메세지
	public static void success(String msg) {
		System.out.println(msg);
	}
	
	//정상 response 아닐 시 출력 메세지
	public static void fail(String msg) {
		System.out.println(msg);
	}

}
