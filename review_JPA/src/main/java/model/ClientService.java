package model;

import java.sql.SQLException;
import java.util.List;

import model.domain.ClientDTO;

public class ClientService {
	//singleton 만들기
	private static ClientService instance = new ClientService();
	private ClientService() {}
	public static ClientService getInstance() {
		return instance;
	}
	
	//DAO singleton 불러오기
	private static ClientDAO dao = ClientDAO.getInstance();
	
	//기존 회원 정보 DB에 저장
	public boolean inputInfo(List<ClientDTO> clients) {
		boolean result = false;
		try {
			result = dao.inputClientInfo(clients);
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return result;
	}
	
	
	//getAll
	public List<ClientDTO> getAllInfo() {
		List<ClientDTO> allInfo = null;
		try {
			allInfo = dao.getAll();
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return allInfo;
	}
	
	
	//create : 신규회원 등록
	public boolean addInfo(ClientDTO clientInfo) {
		boolean result = false;
		try {
			result = dao.addClinet(clientInfo);			
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return result;
	}
	
	//read : name 입력하면 해당 회원정보 return
	public ClientDTO getInfo(String name) {
		ClientDTO info = null;
		try {
			info = dao.getClientInfo(name);
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return info;
	}
	
	//update : 회원 정보 수정
	public boolean updateInfo(ClientDTO clientInfo) {
		boolean result = false;
		try {
			result = dao.updateClientInfo(clientInfo);
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return result;
	}
	
	//delete : 회원 정보 삭제
	public boolean deleteInfo(String name) {
		boolean result = false;
		try {
			result = dao.deleteClientInfo(name);
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return result;
	}

}
