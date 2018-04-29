package com.realestate.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestate.models.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "SELECT * FROM user u WHERE u.email = :email AND u.password = :password", nativeQuery= true)
	public User getUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	@Query(value = "SELECT id FROM user u WHERE u.email = :email", nativeQuery= true)
	public Object getUserId(@Param("email") String email);
	
	@Query(value = "SELECT * FROM `user` WHERE type != 'client' ", nativeQuery= true)
	public List<User> getBlockedUsers();
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE user u SET u.blocked = :blocked WHERE u.id = :id", nativeQuery= true)
	public int updateUserStatus(@Param("id") int id, @Param("blocked") int blocked);
	
	
	@Query(value = "SELECT * FROM `user` WHERE type = 'client' ", nativeQuery= true)
	public List<User> getClients();
	
	@Query(value = "SELECT * FROM `user` WHERE type = 'agent' ", nativeQuery= true)
	public List<User> getAgents();
	
	@Query(value = "SELECT * FROM `user` WHERE type = 'operator' ", nativeQuery= true)
	public List<User> getOperators();
	
	@Query(value = "SELECT * FROM `user` WHERE type = 'admin' ", nativeQuery= true)
	public List<User> getAdmins();
	
}
