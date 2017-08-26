package com.websystique.springboot.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.websystique.springboot.model.User2;

public interface User2Repository extends JpaRepository<User2, Long> {

String Q_GET_ALL_USERS = "select u from User2 u left join u.role";

@Query(Q_GET_ALL_USERS)
Collection<User2> getAllUsers();
}