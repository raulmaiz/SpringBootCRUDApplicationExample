package com.websystique.springboot.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springboot.model.User2;
import com.websystique.springboot.repositories.User2Repository;



@Service("user2Service")
@Transactional
public class User2ServiceImpl implements User2Service{

	@Autowired
	private User2Repository user2Repository;

//	public User2 findById(Long id) {
//		return user2Repository.findOne(id);
//	}

	@Override
	public Collection<User2> findAllUsers() {
		return user2Repository.getAllUsers();
	}
	
}
