package com.websystique.springboot.service;

import java.util.List;

import com.websystique.springboot.model.Party;
import com.websystique.springboot.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("partyService")
@Transactional
public class PartyServiceImpl implements PartyService{

	@Autowired
	private PartyRepository partyRepository;

	public Party findById(Long id) {
		return partyRepository.findOne(id);
	}

	public Party findByName(String name) {
		return partyRepository.findByName(name);
	}
	
	public void saveParty(Party party) {
		partyRepository.save(party);
	}

	public void updateParty(Party party){
		saveParty(party);
	}

	public void deletePartyById(Long id){
		partyRepository.delete(id);
	}

	public void deleteAllPartys(){
		partyRepository.deleteAll();
	}

	public List<Party> findAllPartys(){
		return partyRepository.findAll();
	}

	public boolean isPartyExist(Party party) {
		return findByName(party.getName()) != null;
	}

	
}
