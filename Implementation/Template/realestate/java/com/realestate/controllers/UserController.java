package com.realestate.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.realestate.models.User;
import com.realestate.services.UserService;

@Controller
public class UserController {
		
	@Autowired
	private UserService userService;
	private HttpSession session = null;
	
	@GetMapping("/")
	public String get_home() {
		if(userService.session_exists(session)) {	
			return ((User) session.getAttribute("user")).getType().toLowerCase();
		}
			
		else
			return "redirect:/login";
	}
	
		
	@GetMapping("/subscribe")
	public String get_subscribe(){
		
		if(userService.session_exists(session))
			return "redirect:/";
		
		return "subscribe";
	}
	
	@PostMapping("/subscribe")
	public String post_subscribe(@RequestParam String username, @RequestParam String email, @RequestParam String password, @RequestParam String repassword, @RequestParam String name, @RequestParam String f_name, @RequestParam String birthdate, @RequestParam String phone, @RequestParam String address, @RequestParam String gender, HttpServletRequest request) {
		if(userService.getUserId(email) == 0) {
			User user = new User(0, username, password, email, "client", name, f_name, birthdate, phone, address, gender, 0, 0);
			
			if (userService.addUser(user)) {
				session = request.getSession();
				session.setAttribute("user", user);
				return "redirect:/";
			}else {
				request.setAttribute("error", "Error in saving the user in the database.");
			}
		}else {
			request.setAttribute("error", "Email already exists.");
		}
		
		return "subscribe";		
	}
	
	@GetMapping("/login")
	public String get_login(HttpServletRequest request){
		if(userService.session_exists(session))
			return "redirect:/";
		else
			return "login";
	}
	
	@PostMapping("/login")
	public String post_login(@RequestParam String email, @RequestParam String password, HttpServletRequest request){
		User user = userService.getUserByEmailAndPassword(email, password);
		if(user != null) {
			session = request.getSession();
			session.setAttribute("user", user);
			return "redirect:/";

		}else {
			System.out.println("\n\nInvalid login.");
			return "login";
		}
		
	}
	
	@GetMapping("/logout")
	public String get_logout() {
		
		if(session != null) {
			session.invalidate();
			session = null;
		}
			
		
		return "redirect:/";
	}
			
}
