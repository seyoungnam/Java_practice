package view;

import controller.ClientController;
import model.domain.ClientDTO;

public class StartView {
	
	//�ű� ȸ�� ��Ͻ� ���
	public static ClientDTO createClient() {
		return new ClientDTO("Kudos", "UK", 50);
	}
	//ȸ�� �˻�
	public static String nameSearch() {
		return "��ʢʢ";
	}
	//������ ȸ�� ����
	public static ClientDTO changeInfo() {
		return new ClientDTO("Alex King", "FR", 40);
	}
	//������ ȸ�� �̸�
	public static String deleteName() {
		return "��ﱸ";
	}
	
	
	public static void main(String[] args) {
		
		//Controller singleton instance �ҷ�����
		ClientController controller = ClientController.getInstance();
		
		System.out.println("======== ȸ�� ��ü ��� ========");
		controller.request(1);
		System.out.println("");

		System.out.println("======== �ű� ȸ�� ���(Kudos) ========");
		controller.request(2);
		System.out.println("-------- �ű� ��� �ݿ� �� ȸ�� ��ü ��� --------");
		controller.request(1);
		System.out.println("");
		
		System.out.println("======== ���� ȸ�� ���� �˻�(��ʢʢ) ========");
		controller.request(3);
		System.out.println("");
		
		System.out.println("======== ȸ�� ���� ����(Alex King�� country�� age ���� ����) ========");
		controller.request(4);
		System.out.println("-------- ���� �� ȸ�� ��ü ��� --------");
		controller.request(1);
		System.out.println("");
		
		System.out.println("======== ȸ�� ���� ����(��ﱸ ���� ����) ========");
		controller.request(5);
		System.out.println("-------- ���� �� ȸ�� ��ü ��� --------");
		controller.request(1);

	}

}
