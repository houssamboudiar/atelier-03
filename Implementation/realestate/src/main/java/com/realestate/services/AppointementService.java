package com.realestate.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.models.Appointement;
import com.realestate.repositories.AppointementRepository;

@Service
public class AppointementService {
	
	@Autowired
	private AppointementRepository appointementRepository;
	
	public List<Appointement> getAllAppointements(){
		ArrayList<Appointement> appointements = new ArrayList<>();
		appointementRepository.findAll().forEach(appointements::add);
		return appointements;
	}
	
	public Appointement getAppointement(int id) {
		try	{
			return this.getAllAppointements().stream().filter(appointement -> ( appointement.getId() == id ) ).findFirst().get();	
		}catch(Exception e) {
			System.out.println("There is an error in UserService.getUser(). ");
			return null;
		}
	}
	
	public boolean addUser(Appointement appointement) {
		try	{
			appointementRepository.save(appointement);
			return true;
		}catch(Exception e) {
			System.out.println("There is an error in UserService.addUser(). ");
			return false;
		}
	}
		
	public void updateUser(Appointement appointement, int id) {
		try	{
			appointementRepository.save(appointement);
		}catch(Exception e) {
			System.out.println("There is an error in UserService.updateUser(). ");
		}
	}
	
	public void deleteUser(int id) {
		try	{
			appointementRepository.deleteById(id);
		}catch(Exception e) {
			System.out.println("There is an error in UserService.deleteUser(). ");
		}
	}
	
	/****************************************************************************************/
	
	public List<Appointement> getAppointementByLodgementId(int id){
		return appointementRepository.getAppointementByLodgementId(id);
	}
	
	public List<Appointement> getAppointementByClientId(int id){
		return appointementRepository.getAppointementByClientId(id);
	}
	
	public List<Appointement> getAppointementByAgentId(int id){
		return appointementRepository.getAppointementByAgentId(id);
	}
	
	public boolean isAvail(String date, int id){
		if(appointementRepository.getAppointementByDate(date, id) == null )
			return true;
		
		return false;
	}
	
	
	public boolean is_avail_agent(int id, String date){
		if(appointementRepository.getAgentByDate(id, date) == null )
			return true;
		
		return false;
	}
	
	public boolean is_avail_client(int id, String date){
		if(appointementRepository.getClientByDate(id, date) == null )
			return true;
		
		return false;
	}
	
	public boolean saveAppointement(int client, int Agent, int lodgement, String date ) {
		if( appointementRepository.saveAppointement(client, Agent, lodgement, date) == 1)
			return true;
		return false;
	}
	
	public int confirmAppointementByAgentId(int id, int confirm) {
		return appointementRepository.confirmAppointementByAgentId(id, confirm);
	}
	
	public int confirmAppointementByClientId(int id, int confirm) {
		return appointementRepository.confirmAppointementByClientId(id, confirm);
	}
	
	public Appointement getAppointementById(int id) {
		return appointementRepository.getAppointementById(id);
	}
		
	public void changeAppointement(int id, String Date ) {
		appointementRepository.changeAppointement(id, Date);
	}
	
	public int deleteAppointement(int id) {
		return appointementRepository.deleteAppointement(id);
	}
	
	public List<Integer> getAllIds(int id) {
		return appointementRepository.getAllIds(id);
	}
	
	public void save_review(int id, String review) {
		appointementRepository.save_review(id, review);
	}

	public List<String> getAllReviewByAppointementId(int id) {
		return appointementRepository.getAllReviewByAppointementId(id);
	}
	
}
