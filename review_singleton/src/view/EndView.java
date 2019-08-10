package view;

import model.domain.ClientDTO;

public class EndView {
	
	//��ü DB ���� ���
	public static void printAll(ClientDTO[] all) {
		for(ClientDTO v : all) {
			if(v != null) {
				System.out.println(v.toString());
			}
		}
	}
	
	//���� ȸ�� ���� ���
	public static void printLine(ClientDTO line) {
		if(line != null) {
			System.out.println(line.toString());
		}	
	}
	
	//���� response�� ��� �޼���
	public static void success(String msg) {
		System.out.println(msg);
	}
	
	//���� response �ƴ� �� ��� �޼���
	public static void fail(String msg) {
		System.out.println(msg);
	}

}
