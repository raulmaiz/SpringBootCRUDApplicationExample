package com.websystique.springboot.controller;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.websystique.springboot.model.User2;
import com.websystique.springboot.service.User2Service;
import com.websystique.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiControllerUser2 {

	public static final Logger logger = LoggerFactory.getLogger(RestApiControllerUser.class);

	@Autowired
	User2Service user2Service; //Service which will do all data retrieval/manipulation work
	
	@RequestMapping(value = "/user2/", method = RequestMethod.GET)
	public ResponseEntity<Collection<User2>> listAllUsers() {
		Collection<User2> users = user2Service.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity(new CustomErrorType("Users not found"), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Collection<User2>>(users, HttpStatus.OK);
	}
	
	// -------------------Do Login---------------------------------------------

}