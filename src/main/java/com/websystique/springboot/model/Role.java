package com.websystique.springboot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

	

@Entity
@Table(name = "role")
public class Role {

@Id
@Column(name = "id")
private long id;

@Column(name = "name", length = 45)
private String name;

@JsonManagedReference
@OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
private Set<User2> user = new HashSet<>();

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Set<User2> getUser() {
	return user;
}

public void setUser(Set<User2> user) {
	this.user = user;
}

//getters and setters
}
