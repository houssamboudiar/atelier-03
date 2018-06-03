package com.realestate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.models.Operator;
import com.realestate.repositories.OperatorRepository;

@Service
public class OperatorService {
	
	@Autowired
	private OperatorRepository operatorRepository; 

	public boolean operator_subscribe(Operator operator) {
		if(operatorRepository.operator_subscribe(	operator.getId(), 
													operator.getEmail(), 
													operator.getGender(), 
													operator.getBirthdate(), 
													operator.getBlocked(), 
													operator.getName(), 
													operator.getPassword(), 
													operator.getLast_name(), 
													operator.getProfile_pic(), 
													operator.getPhone(), 
													operator.getUsername(), 
													operator.getCv(), 
													operator.getLocale())==1)
			
			return true;
		else
		return false;
	}

	public boolean operator_email_exists(String email) {
		if(operatorRepository.get_operator_by_email(email) != null)
			return true;
		else
			return false;
	}

	public Operator get_operator_by_email_and_password(String email, String password) {
		return (Operator)operatorRepository.get_operator_by_email_and_password(email, password);
	}

	public Operator get_operator_by_id(int user_id) {
		return operatorRepository.get_operator_by_id(user_id);
	}

	public int nbr_account() {
		return operatorRepository.nbr_account();
	}


}
