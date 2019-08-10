package controller;

import model.ClientModel;
import model.domain.ClientDTO;
import view.EndView;

public class ClientController {
	public static void request(int num) {
		//num 1 : DB ��ü ��ȸ
		if(num == 1) {
			//DB �� getAll �޼ҵ带 ȣ���Ͽ� ���� ���� EndView�� printAll �޼ҵ�� �ѱ�
			EndView.printAll(ClientModel.getAll());
			
		//num 2 : �ű� ȸ�� ���(create)	
		}else if(num == 2) {
			ClientDTO t = ClientModel.insert(view.StartView.createClient());
			if(t != null) {
				EndView.success("�ű� ȸ�� ��� ����");
				EndView.printLine(t);			
			}else {
				EndView.fail("�ű� ȸ�� ��� ����");
			}
			
		//num 3 : ȸ�� �˻�(read)
		}else if(num == 3) {
			ClientDTO t = ClientModel.search(view.StartView.nameSearch());
			if(t != null) {
				EndView.printLine(t);
			}else {
				EndView.fail("�˻��Ͻ� ȸ���� �����ϴ�.");
			}
			
		//num 4 : ȸ�� ���� ����(update)
		}else if(num == 4) {
			ClientDTO t = ClientModel.update(view.StartView.changeInfo());
			if(t != null) {
				EndView.success("ȸ�� ������ ���������� �����Ǿ����ϴ�.");
				EndView.printLine(t);
			}else {
				EndView.fail("ȸ�� ���� ������Ʈ�� �����Ͽ����ϴ�.");
			}
			
		//num 5 : ȸ�� ���� ����(delete)	
		}else if(num == 5) {
			boolean t = ClientModel.delete(view.StartView.deleteName());
			if(t) {
				EndView.success("ȸ�� ���� ������ �����Ͽ����ϴ�.");
			}else {
				EndView.fail("ȸ�� ���� ������ �����Ͽ����ϴ�.");
			}
		}
	}
}
