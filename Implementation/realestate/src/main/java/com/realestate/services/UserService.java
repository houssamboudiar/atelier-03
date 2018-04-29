package com.realestate.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.models.User;
import com.realestate.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		ArrayList<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	public User getUser(int id) {
		try	{
			return this.getAllUsers().stream().filter(user -> ( user.getId() == id ) ).findFirst().get();	
		}catch(Exception e) {
			System.out.println("There is an error in UserService.getUser(). ");
			return null;
		}
	}
	
	public boolean addUser(User user) {
		try	{
			userRepository.save(user);
			return true;
		}catch(Exception e) {
			System.out.println("There is an error in UserService.addUser(). ");
			return false;
		}
	}
		
	public void updateUser(User user, int id) {
		try	{
			userRepository.save(user);
		}catch(Exception e) {
			System.out.println("There is an error in UserService.updateUser(). ");
		}
	}
	
	public void deleteUser(int id) {
		try	{
			userRepository.deleteById(id);
		}catch(Exception e) {
			System.out.println("There is an error in UserService.deleteUser(). ");
		}
	}
	
	
	/*****************************************************************************************************************************/
	
	public User getUserByEmailAndPassword(String email, String password) {
		return userRepository.getUserByEmailAndPassword(email, password);		
	}
	
	public int getUserId(String email) {
		if( userRepository.getUserId(email) == null)
			return 0;
		return (Integer)userRepository.getUserId(email);
	}
		
	public List<User> blockedUsers() {
		return  userRepository.getBlockedUsers();
	}
	
	public int updateUserStatus(int id, int blocked) {
		return userRepository.updateUserStatus( id, blocked);
	}
	
	public List<User> getClients(){
		return userRepository.getClients();
	}
	
	public List<User> getAgents(){
		return userRepository.getAgents();
	}
	
	public List<User> getAdmins(){
		return userRepository.getAdmins();
	}
	
	public List<User> getOperators(){
		return userRepository.getOperators();
	}
	
			
}
