//ClientModel의 역할 : client 명부 DB이자, DB에서 수행 가능한 crud 기능 정의
package model;


import model.domain.ClientDTO;

public class ClientModel {
	//DB의 기초단위는 ClientDTO
	//ClientDTO로 구성된 array([])와 int가 DB의 field(전역변수)
	private static ClientDTO[] clientDB = new ClientDTO[10];
	
	//DB에 기존재하는 데이터를 static{}에 수기 입력
	//static{}: byte code 로딩시 자동으로 실행되는 특화 코드
	static {
		clientDB[0] = new ClientDTO("Alex King", "US", 30);
		clientDB[1] = new ClientDTO("김삼구", "KR", 29);
		clientDB[2] = new ClientDTO("宋佳佳", "CN", 28);
	}
	
	
	//DB 내 모든 정보 불러오기
	public static ClientDTO[] getAll() {
		return clientDB;
	}
	
	//create(insert) 기능 : 신규회원 등록
	public static ClientDTO insert(ClientDTO v) {
		for(int i=0; i<clientDB.length; i++) {
			if(clientDB[i] == null) {
				clientDB[i] = v;
				return clientDB[i];
			}
		}return null;
	}
	
	//read(search) 기능 : 회원 이름 검색하면 해당 회원 나머지 정보 산출
	//검색 로직 만들 땐, for문과 if문을 섞는다
	//검색한 결과값을 표시하기 위해 return이 필요한 상황이나, 회원이 있는 경우와 없는 경우로 나눠져
	//return type을 지정하기 어렵다. 
	//따라서 boolean으로 설정해주고 true시 회원정보를 향후 가져올 수 있게 세팅
	public static ClientDTO search(String name) {
		ClientDTO v = null;
		for(int i=0; i<clientDB.length; i++) {
			v = clientDB[i];
			//변수값이 같은지를 찾을 때는 ==가 아닌 equals()를 사용
			if(v != null && v.getName().equals(name)) {
				return v;
			}
		}
		return null;
	}
	
	//update 기능 : 회원정보 수정(이름을 검색한 후 country와 age를 수정)
	public static ClientDTO update(ClientDTO clientInfo) {
		for(int i=0; i<clientDB.length; i++) {
			if(clientDB[i].getName().equals(clientInfo.getName())) {
				clientDB[i].setCountry(clientInfo.getCountry());
				clientDB[i].setAge(clientInfo.getAge());
				return clientDB[i];
			}
		}
		return null;
	}
	
	//delete 기능 : 회원 삭제
	public static boolean delete(String name) {
		for(int i=0; i<clientDB.length; i++) {
			if(clientDB[i].getName().equals(name)) {
				clientDB[i] = null;
			return true;
			}
		}
		return false;
	}
}
