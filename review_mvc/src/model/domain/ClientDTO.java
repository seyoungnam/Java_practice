//ClientDTO의 역할 : 신규 client 정보가 들어오면 DB에 입력해주는 기능을 정의
package model.domain;

//class : 설계도, 첫글자는 대문자 사용, field/constructor/method로 구성
public class ClientDTO {
	//field(멤버변수): class 안에 지정되는 변수
	private String name;
	private String country;
	private int age;
	
	//constructor(생성자) : 객체 생성시 호출하는 값
	public ClientDTO() {}
	public ClientDTO(String name, String country, int age) {
		//this?
		//	- instance의 자기자신을 의미
		//  - field(전역변수)와 constructor의 parameter가 동일할 때, instance field임을 명확히 하기 위해 사용
		
		this.name = name; //왼쪽 this.name은 field, 오른쪽 name은 parameter를 의미
		this.country = country;
		this.age = age;
		
	}
	
	//method : 클래스 혹은 instance에서 사용 가능한 기능들
	//DTO에서는 데이터를 불러오는 get(), 데이터를 입력하는 set() 기능을 가지고 있어야 한다
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
			System.out.println("무효");
		}
	}
	//입력한 "name country age"를 불러오는 toString() 기능 추가
 	public String toString() {
		return name+ " " + country + " "+ age;
	}
	
}

// reference sites
// http://blog.naver.com/PostView.nhn?blogId=heartflow89&logNo=220957355593&beginTime=0&jumpingVid=&from=section&redirect=Log&widgetTypeCall=true

