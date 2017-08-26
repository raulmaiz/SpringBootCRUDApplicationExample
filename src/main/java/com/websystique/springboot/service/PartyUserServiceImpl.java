package com.websystique.springboot.service;

import java.util.List;

import com.websystique.springboot.model.PartyUser;
import com.websystique.springboot.model.User;
import com.websystique.springboot.repositories.PartyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("partyUserService")
@Transactional
public class PartyUserServiceImpl implements PartyUserService{

	@Autowired
	private PartyUserRepository partyUserRepository;

	public PartyUser findById(Long id) {
		return partyUserRepository.findOne(id);
	}
//
//	public PartyUser findByName(String name) {
//		return partyUserRepository.findByName(name);
//	}
	
	public void savePartyUser(PartyUser partyUser) {
		partyUserRepository.save(partyUser);
	}

	public void updatePartyUser(PartyUser partyUser){
		savePartyUser(partyUser);
	}

	public void deletePartyUserById(Long id){
		partyUserRepository.delete(id);
	}

	public void deleteAllPartyUsers(){
		partyUserRepository.deleteAll();
	}

	public List<PartyUser> findAllPartyUsers(){
		return partyUserRepository.findAll();
	}

//	public List<User> getUsersFromParty(Long idParty){
//		return partyUserRepository.getUsersFromParty(idParty);
//	}
	
//	public boolean isPartyUserExist(PartyUser partyUser) {
//		return findByName(partyUser.getName()) != null;
//	}

	
}
