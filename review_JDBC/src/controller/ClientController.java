package controller;

import model.ClientService;
import model.domain.ClientDTO;
import view.EndView;

public class ClientController {
	//Singleton ����
	private static ClientController instance = new ClientController();
	private ClientController() {}
	public static ClientController getInstance() {
		return instance;
	}
	//service singleton �ҷ�����
	private static ClientService service = ClientService.getInstance();
	
	//1. private ������ ����� getInstance method �����
	
	
	//static ����
	public void request(int num) {
		//num 1 : DB ��ü ��ȸ
		if(num == 1) {
			EndView.printAll(service.getAllInfo());
			
		//num 2 : �ű� ȸ�� ���(create)	
		}else if(num == 2) {
			boolean t = service.addInfo(view.StartView.createClient());
			if(t != false) {
				EndView.success("�ű� ȸ�� ��� ����");			
			}else {
				EndView.fail("�ű� ȸ�� ��� ����");
			}
			
		//num 3 : ȸ�� �˻�(read)
		}else if(num == 3) {
			ClientDTO t = service.getInfo(view.StartView.nameSearch());
			if(t != null) {
				EndView.printLine(t);
			}else {
				EndView.fail("�˻��Ͻ� ȸ���� �����ϴ�.");
			}
			
		//num 4 : ȸ�� ���� ����(update)
		}else if(num == 4) {
			boolean t = service.updateInfo(view.StartView.changeInfo());
			if(t != false) {
				EndView.success("ȸ�� ������ ���������� �����Ǿ����ϴ�.");
			}else {
				EndView.fail("ȸ�� ���� ������Ʈ�� �����Ͽ����ϴ�.");
			}
			
		//num 5 : ȸ�� ���� ����(delete)	
		}else if(num == 5) {
			boolean t = service.deleteInfo(view.StartView.deleteName());
			if(t) {
				EndView.success("ȸ�� ���� ������ �����Ͽ����ϴ�.");
			}else {
				EndView.fail("ȸ�� ���� ������ �����Ͽ����ϴ�.");
			}
		}
	}
}
