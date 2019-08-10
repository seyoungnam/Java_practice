//ClientModel�� ���� : client ��� DB����, DB���� ���� ������ crud ��� ����
package model;


import model.domain.ClientDTO;

public class ClientModel {
	//DB�� ���ʴ����� ClientDTO
	//ClientDTO�� ������ array([])�� int�� DB�� field(��������)
	private static ClientDTO[] clientDB = new ClientDTO[10];
	
	//DB�� �������ϴ� �����͸� static{}�� ���� �Է�
	//static{}: byte code �ε��� �ڵ����� ����Ǵ� Ưȭ �ڵ�
	static {
		clientDB[0] = new ClientDTO("Alex King", "US", 30);
		clientDB[1] = new ClientDTO("��ﱸ", "KR", 29);
		clientDB[2] = new ClientDTO("��ʢʢ", "CN", 28);
	}
	
	
	//DB �� ��� ���� �ҷ�����
	public static ClientDTO[] getAll() {
		return clientDB;
	}
	
	//create(insert) ��� : �ű�ȸ�� ���
	public static ClientDTO insert(ClientDTO v) {
		for(int i=0; i<clientDB.length; i++) {
			if(clientDB[i] == null) {
				clientDB[i] = v;
				return clientDB[i];
			}
		}return null;
	}
	
	//read(search) ��� : ȸ�� �̸� �˻��ϸ� �ش� ȸ�� ������ ���� ����
	//�˻� ���� ���� ��, for���� if���� ���´�
	//�˻��� ������� ǥ���ϱ� ���� return�� �ʿ��� ��Ȳ�̳�, ȸ���� �ִ� ���� ���� ���� ������
	//return type�� �����ϱ� ��ƴ�. 
	//���� boolean���� �������ְ� true�� ȸ�������� ���� ������ �� �ְ� ����
	public static ClientDTO search(String name) {
		ClientDTO v = null;
		for(int i=0; i<clientDB.length; i++) {
			v = clientDB[i];
			//�������� �������� ã�� ���� ==�� �ƴ� equals()�� ���
			if(v != null && v.getName().equals(name)) {
				return v;
			}
		}
		return null;
	}
	
	//update ��� : ȸ������ ����(�̸��� �˻��� �� country�� age�� ����)
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
	
	//delete ��� : ȸ�� ����
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
