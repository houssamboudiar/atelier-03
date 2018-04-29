package com.realestate.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.realestate.models.Lodgement;
import com.realestate.models.User;
import com.realestate.repositories.LodgementRepository;

@Service
public class LodgementService {

	@Autowired
	private LodgementRepository lodgementRepository;
	
	
	public List<Lodgement> getAllLodgements(){
		ArrayList<Lodgement> lodgements = new ArrayList<>();
		lodgementRepository.findAll().forEach(lodgements::add);
		return lodgements;
	}
	
	public Lodgement getLogement(int id) {
		try	{
			return this.getAllLodgements().stream().filter(lodgement -> ( lodgement.getId() == id ) ).findFirst().get();	
		}catch(Exception e) {
			System.out.println("There is an error in UserService.getUser(). ");
			return null;
		}
	}
	
	public boolean addLodgement(Lodgement lodgement) {
		try	{
			lodgementRepository.save(lodgement);
			return true;
		}catch(Exception e) {
			System.out.println("There is an error in UserService.addUser(). ");
			return false;
		}
	}
		
	public void updateUser(Lodgement lodgement, int id) {
		try	{
			lodgementRepository.save(lodgement);
		}catch(Exception e) {
			System.out.println("There is an error in UserService.updateUser(). ");
		}
	}
	
	public void deleteUser(int id) {
		try	{
			lodgementRepository.deleteById(id);
		}catch(Exception e) {
			System.out.println("There is an error in UserService.deleteUser(). ");
		}
	}
	
	/*******/
	
	public List<Lodgement> getLodgementByState(String state){
		return lodgementRepository.getLodgementByState(state);
	}
	
	public List<Lodgement> getFreeLodgementByState(String state){
		return lodgementRepository.getFreeLodgementByState(state);
	}
	
	public Lodgement getLodgementById(int id){
		return lodgementRepository.getLodgementById(id);
	}
	

	public int updateLodgementStatus(int id, int reserved) {
		return lodgementRepository.updateLodgementStatus( id, reserved);
	}
	
}
