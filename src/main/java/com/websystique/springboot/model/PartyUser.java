package com.websystique.springboot.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="PARTY_USER")
public class PartyUser implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	
	@Column(name="ID_PARTY", nullable=false)
	private int idParty;
	
	@Column(name="ID_USER", nullable=false)
	private int idUser;
	
	
	@Column(name="ADMIN", nullable=false)
	private boolean admin;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIdParty() {
		return idParty;
	}

	public void setIdParty(int idParty) {
		this.idParty = idParty;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	
//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || getClass() != o.getClass()) return false;
//
//		User user = (User) o;
//
//		if (Double.compare(user.salary, salary) != 0) return false;
//		if (id != null ? !id.equals(user.id) : user.id != null) return false;
//		if (name != null ? !name.equals(user.name) : user.name != null) return false;
//		return age != null ? age.equals(user.age) : user.age == null;
//	}
//
//	@Override
//	public int hashCode() {
//		int result;
//		long temp;
//		result = id != null ? id.hashCode() : 0;
//		result = 31 * result + (name != null ? name.hashCode() : 0);
//		result = 31 * result + (age != null ? age.hashCode() : 0);
//		temp = Double.doubleToLongBits(salary);
//		result = 31 * result + (int) (temp ^ (temp >>> 32));
//		return result;
//	}
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", name=" + name + ", age=" + age
//				+ ", salary=" + salary + "]";
//	}


}
