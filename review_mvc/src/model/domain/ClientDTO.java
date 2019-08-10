//ClientDTO�� ���� : �ű� client ������ ������ DB�� �Է����ִ� ����� ����
package model.domain;

//class : ���赵, ù���ڴ� �빮�� ���, field/constructor/method�� ����
public class ClientDTO {
	//field(�������): class �ȿ� �����Ǵ� ����
	private String name;
	private String country;
	private int age;
	
	//constructor(������) : ��ü ������ ȣ���ϴ� ��
	public ClientDTO() {}
	public ClientDTO(String name, String country, int age) {
		//this?
		//	- instance�� �ڱ��ڽ��� �ǹ�
		//  - field(��������)�� constructor�� parameter�� ������ ��, instance field���� ��Ȯ�� �ϱ� ���� ���
		
		this.name = name; //���� this.name�� field, ������ name�� parameter�� �ǹ�
		this.country = country;
		this.age = age;
		
	}
	
	//method : Ŭ���� Ȥ�� instance���� ��� ������ ��ɵ�
	//DTO������ �����͸� �ҷ����� get(), �����͸� �Է��ϴ� set() ����� ������ �־�� �Ѵ�
	//getName(), setName()
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//getCountry(), setCountry()
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	//getAge(), setAge() 
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if( age > 0 ) {
			this.age = age;
		} else {
			System.out.println("��ȿ");
		}
	}
	//�Է��� "name country age"�� �ҷ����� toString() ��� �߰�
 	public String toString() {
		return name+ " " + country + " "+ age;
	}
	
}

// reference sites
// http://blog.naver.com/PostView.nhn?blogId=heartflow89&logNo=220957355593&beginTime=0&jumpingVid=&from=section&redirect=Log&widgetTypeCall=true

