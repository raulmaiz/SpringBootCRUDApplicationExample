package com.websystique.springboot.service;


import com.websystique.springboot.model.PartyUser;
import com.websystique.springboot.model.User;

import java.util.List;

public interface PartyUserService {
	
	PartyUser findById(Long id);

//	PartyUser findByName(String name);
	
	void savePartyUser(PartyUser partyUser);

	void updatePartyUser(PartyUser partyUser);

	void deletePartyUserById(Long id);

	void deleteAllPartyUsers();

	List<PartyUser> findAllPartyUsers();

//	List<User> getUsersFromParty(Long idParty);

//	boolean isPartyUserExist(PartyUser partyUser);
	
}