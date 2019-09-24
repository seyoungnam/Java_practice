package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "clientlist")
public class ClientDTO {
	@Id
	@GeneratedValue(generator = "clientlist_id_seq")
	private int id;
	@Column(length = 30)
	private String name;
	@Column(length = 10)
	private String country;
	@Column(length = 10)
	private int age;
	
	public ClientDTO(String name, String country, int age) {
		this.name = name;
		this.country = country;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "[ID : " + id + ", 회원명 : " + name + ", 국적 : " + country + ", 나이 : " + age + "]";
	}
}

