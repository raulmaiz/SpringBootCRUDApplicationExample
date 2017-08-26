package com.websystique.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.websystique.springboot.model.Party;
import com.websystique.springboot.model.User;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

    Party findByName(String name);

    
}
