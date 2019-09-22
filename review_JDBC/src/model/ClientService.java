package model;

import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.ClientDTO;

public class ClientService {
	//singleton �����
	private static ClientService instance = new ClientService();
	private ClientService() {}
	public static ClientService getInstance() {
		return instance;
	}
	
	//DAO singleton �ҷ�����
	private static ClientDAO dao = ClientDAO.getInstance();
	
	//getAll
	public ArrayList<ClientDTO> getAllInfo() {
		ArrayList<ClientDTO> allInfo = null;
		try {
			allInfo = dao.getAll();
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return allInfo;
	}
	
	
	//create : �ű�ȸ�� ���
	public boolean addInfo(ClientDTO clientInfo) {
		boolean result = false;
		try {
			result = dao.addClinet(clientInfo);			
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return result;
	}
	
	//read : name �Է��ϸ� �ش� ȸ������ return
	public ClientDTO getInfo(String name) {
		ClientDTO info = null;
		try {
			info = dao.getClientInfo(name);
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return info;
	}
	
	//update : ȸ�� ���� ����
	public boolean updateInfo(ClientDTO clientInfo) {
		boolean result = false;
		try {
			result = dao.updateClientInfo(clientInfo);
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return result;
	}
	
	//delete : ȸ�� ���� ����
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
