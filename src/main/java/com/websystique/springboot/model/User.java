package com.websystique.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@Column(name="PASSWORD", nullable=false)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
