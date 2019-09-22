package model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //toSring,Getter,Setter, EqaulsAndHashCode, RequiredArgsConstructor ����
@AllArgsConstructor //��� parameter�� �� �ִ� constructor ����
@NoArgsConstructor //parameter���� constructor ����
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

