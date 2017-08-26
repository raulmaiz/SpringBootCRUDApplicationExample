package com.websystique.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.websystique.springboot.model.PartyUser;
import com.websystique.springboot.model.User;

@Repository
public interface PartyUserRepository extends JpaRepository<PartyUser, Long> {

//    PartyUser findByName(String name);
//	
//    @Query("select u from User u left join u.role")
//	public List<User> getUsersFromParty(@Param("idParty") Long idParty);

}
