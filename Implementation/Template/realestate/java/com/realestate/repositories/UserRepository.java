package com.realestate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestate.models.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "SELECT * FROM user u WHERE u.email = :email AND u.password = :password", nativeQuery= true)
	public User getUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
	@Query(value = "SELECT id FROM user u WHERE u.email = :email", nativeQuery= true)
	public Object getUserId(@Param("email") String email);
	
}
