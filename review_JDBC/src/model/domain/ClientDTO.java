package model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //toSring,Getter,Setter, EqaulsAndHashCode, RequiredArgsConstructor 포함
@AllArgsConstructor //모든 parameter가 들어가 있는 constructor 생성
@NoArgsConstructor //parameter없는 constructor 생성
public class ClientDTO {
	private int id;
	private String name;
	private String country;
	private int age;
	
	public ClientDTO(String name, String country, int age) {
		this.name = name;
		this.country = country;
		this.age = age;
	}
	
}

// reference sites
// https://goddaehee.tistory.com/95

