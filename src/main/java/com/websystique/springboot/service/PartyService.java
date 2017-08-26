package com.websystique.springboot.service;


import com.websystique.springboot.model.Party;

import java.util.List;

public interface PartyService {
	
	Party findById(Long id);

	Party findByName(String name);
	
	void saveParty(Party party);

	void updateParty(Party party);

	void deletePartyById(Long id);

	void deleteAllPartys();

	List<Party> findAllPartys();

	boolean isPartyExist(Party party);
	
}