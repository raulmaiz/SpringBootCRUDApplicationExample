package com.websystique.springboot.repositories;

import com.websystique.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

	User findByEmail(String email);
	
    @Query("SELECT u FROM User u where u.email = :email AND u.password = :password")
    public User findByEmailAndPassword(@Param("email") String email, 
                                                    @Param("password") String password);

}
