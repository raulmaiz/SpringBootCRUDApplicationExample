package com.websystique.springboot.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;

@Entity
@Table(name = "PARTY")
public class Party implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "CAPACITY", nullable = false)
	private Integer capacity;

	@Column(name = "LEVEL", nullable = false)
	private Integer level;

	@Column(name = "LONGITUDE", nullable = false)
	private float longitude;

	@Column(name = "LATITUDE", nullable = false)
	private float latitude;

	@Column(name = "ADDRESS", nullable = false)
	private String address;

	@Column(name = "STARTS", nullable = false)
	private Date starts;

	@Column(name = "DURATION", nullable = false)
	private Integer duration;

	@Column(name = "STATUS", nullable = false)
	private Integer status;

	@Column(name = "PRICE", nullable = true)
	private Integer price;
	
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

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public Date getStarts() {
		return starts;
	}

	public void setStarts(Date starts) {
		this.starts = starts;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	// public String getUpdateDate() {
	// return updateDate;
	// }
	//
	// public void setUpdateDate(String updateDate) {
	// this.updateDate = updateDate;
	// }
	//
	// public String getCreationDate() {
	// return creationDate;
	// }
	//
	// public void setCreationDate(String creationDate) {
	// this.creationDate = creationDate;
	// }

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// @Override
	// public boolean equals(Object o) {
	// if (this == o) return true;
	// if (o == null || getClass() != o.getClass()) return false;
	//
	// User user = (User) o;
	//
	// if (Double.compare(user.salary, salary) != 0) return false;
	// if (id != null ? !id.equals(user.id) : user.id != null) return false;
	// if (name != null ? !name.equals(user.name) : user.name != null) return false;
	// return age != null ? age.equals(user.age) : user.age == null;
	// }
	//
	// @Override
	// public Integer hashCode() {
	// int result;
	// long temp;
	// result = id != null ? id.hashCode() : 0;
	// result = 31 * result + (name != null ? name.hashCode() : 0);
	// result = 31 * result + (age != null ? age.hashCode() : 0);
	// temp = Double.doubleToIntegerBits(salary);
	// result = 31 * result + (Integer) (temp ^ (temp >>> 32));
	// return result;
	// }
	//
	// @Override
	// public String toString() {
	// return "User [id=" + id + ", name=" + name + ", age=" + age
	// + ", salary=" + salary + "]";
	// }

}
