package com.websystique.springboot.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "user2")
public class User2 {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id",insertable = false, updatable = false)
private long id;

@Column(name = "login")
private String login;

@Column(name = "user_name")
private String userName;

@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinColumn(name="role_id")
@JsonBackReference
private Role role;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}

//getters and setters
}