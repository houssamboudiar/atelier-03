package com.realestate.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.realestate.models.Appointement;
import com.realestate.models.Lodgement;
import com.realestate.models.User;
import com.realestate.repositories.LodgementRepository;
import com.realestate.services.AppointementService;
import com.realestate.services.LodgementService;
import com.realestate.services.UserService;

@Controller
public class UserController {
		
	@Autowired
	private UserService userService;
	
	@Autowired
	private LodgementService lodgementService;
	
	@Autowired
	private LodgementRepository lodgementRepository;
	
	@Autowired
	private AppointementService appointementService;
	
	@GetMapping("/")
	public String get_home(HttpServletRequest request) {
				
		HttpSession session = request.getSession();
		if((session.getAttribute("user") != null)) {
			return 	((User)session.getAttribute("user")).getType().toLowerCase();
		}else {
			return "index";
		}
	}
	
	
	/* The login */
	@GetMapping("/login")
	public String get_login(HttpServletRequest request){
		
		if(request.getSession().getAttribute("user") != null) {
			return "redirect:/";
		}else {
			return "login";
		}
			
	}
	
	@PostMapping("/login")
	public String post_login(@RequestParam String email, @RequestParam String password, HttpServletRequest request){
		User user = userService.getUserByEmailAndPassword(email, password);
		if(user != null ) { // the email and password are correct.
			if(user.getBlocked() == 0) {  // the account is not blocked.
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				request.getRequestURI();
				
				if(session.getAttribute("url") != null)
					return "redirect:"+((String) session.getAttribute("url"));
				
				return "redirect:/";
			}else {   // the account is blocked.
				request.setAttribute("login_err", "show");
				request.setAttribute("login_msg", "This account is blocked. Please contact the client service for details.");
			}
				
		}else { // the email and password are not correct.
			request.setAttribute("login_err", "show");
			
			if(userService.getUserId(email) == 0) { // the email is inccorect
				request.setAttribute("login_msg", "This email is not assocaited to any account. <a href='/subscribe'>subscribe</a>.");
			}else { // the password is inccorect
				request.setAttribute("login_msg", "Wrong password.");
				
				/*
					request.setAttribute("login_msg", "Forget your password? <a href='/reset_password'>You can reset it Here.</a>");
				*/
			}	
		}
		
		return "login";
		
	}
	
	
	/*The logout*/
	@GetMapping("/logout")
	public String get_logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null) { //the user is logged in.
			session.invalidate();
		}
		
		return "redirect:/";
	}
	
	
	/*The password reset*/
	@GetMapping("/reset_password")
	public String reset_passsword(HttpServletRequest request) {
		if(request.getSession().getAttribute("user") != null) {
			return "redirect:/";
		}else {
			return "reset_password";
		}
	}
	
	/*
	 * @PostMapping("/reset_password")
	 */
	
	
	
	/*The subscribe*/
	@GetMapping("/subscribe")
	public String get_subscribe(HttpServletRequest request){
		
		if(request.getSession().getAttribute("user") != null) // the user is logged in
			return "redirect:/";

		return "subscribe";
	}
	
	@PostMapping("/subscribe")
	public String post_subscribe(@RequestParam String username, @RequestParam String email, @RequestParam String type, @RequestParam String password, @RequestParam String repassword, @RequestParam String name, @RequestParam String f_name, @RequestParam String birthdate, @RequestParam String phone, @RequestParam String address, @RequestParam String gender, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int blocked = 1;
		
		if(type.equalsIgnoreCase("client")) {
			blocked = 0;
		}
		
		// infos non valid
		if(username.equals(null) || email.equals(null) || type.equals(null)  || ( !type.equals("client") && !type.equals("agent") && !type.equals("operator") ) || password.equals(null) || repassword.equals(null) || name.equals(null) || f_name.equals(null) || gender.equals(null) || !password.equals(repassword) || password.length()<6) {

			request.setAttribute("sub_err", "show");
			request.setAttribute("sub_msg", "Informations invalid.");
			
			if(username.equals(null))
				request.setAttribute("sub_msg", "The username can not be empty.");
			
			if(email.equals(null))
				request.setAttribute("sub_msg", "The email can not be empty.");
			
			if( ( !type.equals("client") && !type.equals("agent") && !type.equals("operator") ))
				request.setAttribute("sub_msg", "Invalid type.");
			
			if(password.equals(null) || password.length() < 6)
				request.setAttribute("sub_msg", "The password should be more the 6 chars.");
			
			if(!password.equals(repassword))
				request.setAttribute("sub_msg", "Inconfirmed password.");		
					
		}else {
			User user = new User(0, username, password, email, type, name, f_name, birthdate, phone, address, gender, blocked);
			
			// the email already used 
			if(userService.getUserId(email) == 0) {
					// adding the user to the database
				
//				 // Recipient's email ID needs to be mentioned.
//			      String to = request.getParameter("email");
//
//			      // Sender's email ID needs to be mentioned
//			      String from = "SENDER_EMAIL";
//
//			      // Assuming you are sending email from localhost
//			      String host = "YOUR_EMAIL_HOST";
//
//			      // Get system properties
//			      Properties properties = System.getProperties();
//
//			      // Setup mail server
//			      properties.setProperty("mail.smtp.host", host);
//
//
//			      try{
//			         // Create a default MimeMessage object.
//			         MimeMessage message = new MimeMessage(session);
//
//			         // Set From: header field of the header.
//			         message.setFrom(new InternetAddress(from));
//
//			         // Set To: header field of the header.
//			         message.addRecipient(Message.RecipientType.TO,
//			                                  new InternetAddress(to));
//
//			         // Set Subject: header field
//			         message.setSubject("SUVJECT_LINE");
//
//			         // Now set the actual message
//			         message.setText("YOUR MESSAGE GOES HERE");
//
//			         // Send message
//			         Transport.send(message);
//			         System.out.println("Sent message successfully....");
//			      }catch (MessagingException mex) {
//			         mex.printStackTrace();
//			      }
//			   }
				
					if (userService.addUser(user)) {

						if(type.equals("client")) {
							session = request.getSession();
							session.setAttribute("user", user);
							return "redirect:/";
						}else {
							
							
							
							request.setAttribute("sub_err", "show valid");
							request.setAttribute("sub_msg", "Your account has been created.");
						}
						
					}else {
						request.setAttribute("sub_err", "show");
						request.setAttribute("sub_msg", "Error in saving the user in the database.");
					}
			}else {
				request.setAttribute("sub_err", "show");
				request.setAttribute("sub_msg", "Email already used.");
			}
				
		}
		return "subscribe";	
	}
	
	
	
	/* The block functions */	
	@GetMapping("/users")
	public String get_users(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if((session.getAttribute("user") != null) && ((User)session.getAttribute("user")).getType().toLowerCase().equals("admin")) {
			
			List<User> blockedUsers =  userService.blockedUsers();
			request.setAttribute("users", blockedUsers);
			return "users";
			
		}else {			
						
			request.setAttribute("login_err", "show");
			request.setAttribute("login_msg", "You have to login.");
			
			return "login";
		}		
	}
	
	@PostMapping("/users")
	public void post_users(@RequestParam int id, @RequestParam int blocked,HttpServletRequest request) {
		userService.updateUserStatus(id, blocked);
	}
	
	
	
	/* reserving */
	
	@GetMapping("/lodgement")
	public String get_logement(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if((session.getAttribute("user") != null) && ((User)session.getAttribute("user")).getType().toLowerCase().equals("admin")) {
			
			List<Lodgement> allLodgements =  lodgementService.getAllLodgements();
			request.setAttribute("lodgements", allLodgements);
			return "lodgements";
			
		}else {			
						
			request.setAttribute("login_err", "show");
			request.setAttribute("login_msg", "You have to login.");
			
			return "login";
		}		
	}
	
	@PostMapping("/lodgement")
	public void post_lodgement(@RequestParam int id, @RequestParam int reserved,HttpServletRequest request) {
		lodgementService.updateLodgementStatus(id, reserved);
	}
	
	/* The reserve */
	@GetMapping("/reserve")
	public String get_reserve(@RequestParam int id, HttpServletRequest request) {
		HttpSession session = request.getSession();
				
		if((session.getAttribute("user") != null) && (((User)session.getAttribute("user")).getType().toLowerCase().equals("client"))) {
			@SuppressWarnings("deprecation")
			int day = new Date().getDate();		
			int month = 4;		
			int year = 2018;	
			
			ArrayList<String> dates = next_avail_date(day,month,year,id);
			
			List<User> agents = userService.getAgents();		
			List<User> avail_agents = new ArrayList<User>();
			List<String> appointements_dates = new ArrayList<String>();
			List<Integer> appointements_ids = appointementService.getAllIds((Integer)((User)session.getAttribute("user")).getId());
			List<String> appointements_reviews = appointementService.getAllReviewByAppointementId(id);
			//int count = 1;
			
			for(int i=0; i<dates.size(); i++) {
				avail_agents = new ArrayList<User>();

				appointements_dates.add(dates.get(i));
				
				for(int j=0; j< agents.size(); j++) {
					if(is_avail_agent(agents.get(j), dates.get(i))) {
						avail_agents.add(agents.get(j));
					}
				}

				request.setAttribute("agents"+(i+1), avail_agents);
	
			}
			
			request.setAttribute("appointements_reviews", appointements_reviews);
			request.setAttribute("appointements_dates", appointements_dates);
			request.setAttribute("appointements_ids", appointements_ids);
			request.setAttribute("client", ((User)session.getAttribute("user")).getUsername());
			
			
			session.setAttribute("lodgement", id);
			
			return "reserve";
		
		}else {			
						
			request.setAttribute("login_err", "show");
			request.setAttribute("login_msg", "You have to login.");
			
			String url = request.getRequestURI() + "?" + request.getQueryString();
			System.out.println(url);
			session.setAttribute("url", url);
	
			return "login";
		}		
	}
	
	@PostMapping("/reserve")
	public String post_reserve(@RequestParam int agentId, @RequestParam String date, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if((session.getAttribute("user") != null) && ((User)session.getAttribute("user")).getType().toLowerCase().equals("client")) {

			int lodgementId = (Integer) session.getAttribute("lodgement");
			int clientId = ((User)session.getAttribute("user")).getId();
			
			
			if(appointementService.saveAppointement(clientId, agentId, lodgementId, date))
				System.out.println("[+] Done!.");
			
			return "client";
		}else {			
			
			request.setAttribute("login_err", "show");
			request.setAttribute("login_msg", "You have to login.");
	
			return "login";
		}
		
	}
	
	
	
	/* The reserve */
	@GetMapping("/reserve_op")
	public String get_reserve_op(@RequestParam int id, HttpServletRequest request) {
		HttpSession session = request.getSession();
				
		if((session.getAttribute("user") != null) && (((User)session.getAttribute("user")).getType().toLowerCase().equals("operator"))) {
			@SuppressWarnings("deprecation")
			int day = new Date().getDate();		
			int month = 4;		
			int year = 2018;	
			
			ArrayList<String> dates = next_avail_date(day,month,year,id);
			
			List<User> agents = userService.getAgents();
			List<User> clients = userService.getClients();
			List<User> avail_agents = new ArrayList<User>();
			List<User> avail_clients = new ArrayList<User>();
			List<String> appointements = new ArrayList<String>();
			List<Integer> appointements_ids = appointementService.getAllIds((Integer)((User)session.getAttribute("user")).getId());
			//int count = 1;
			
			for(int i=0; i<dates.size(); i++) {
				avail_agents = new ArrayList<User>();
				avail_clients =  new ArrayList<User>();
				appointements.add(dates.get(i));
				
				for(int j=0; j< agents.size(); j++) {
					if(is_avail_agent(agents.get(j), dates.get(i))) {
						avail_agents.add(agents.get(j));
					}
				}
				
				for(int k=0; k< clients.size(); k++) {
					if(is_avail_agent(clients.get(k), dates.get(i))) {
						avail_clients.add(clients.get(k));
					}
				}
				

				request.setAttribute("agents"+(i+1), avail_agents);
				request.setAttribute("clients"+(i+1), avail_clients);
	
			}
			
			
			request.setAttribute("appointements", appointements);
			request.setAttribute("appointements_ids", appointements_ids);
			request.setAttribute("operator", ((User)session.getAttribute("user")).getUsername());
			
			
			session.setAttribute("lodgement", id);
			
			return "reserve_op";
		
		}else {			
						
			request.setAttribute("login_err", "show");
			request.setAttribute("login_msg", "You have to login.");
			
			String url = request.getRequestURI() + "?" + request.getQueryString();
			System.out.println(url);
			session.setAttribute("url", url);
	
			return "login";
		}		
	}
	

	@PostMapping("/reserve_op")
	public String post_reserve_op(@RequestParam int agentId, @RequestParam int clientId, @RequestParam String date, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if((session.getAttribute("user") != null) && ((User)session.getAttribute("user")).getType().toLowerCase().equals("operator")) {

			int lodgementId = (Integer) session.getAttribute("lodgement");
			
			System.out.println(clientId+" = "+ agentId+" - "+lodgementId +" - "+date);
			if(appointementService.saveAppointement(clientId, agentId, lodgementId, date))
				System.out.println("[+] Done!.");
			
			return "operator";
		}else {			
			
			request.setAttribute("login_err", "show");
			request.setAttribute("login_msg", "You have to login.");
	
			return "login";
		}
		
	}
	
	
	
	public boolean isAvail(int day, int month, int year, int id) {
		
		String date = year+"-";
		
		if(month < 10) {
			date = date+"0"+month+"-";
		}else {
			date = date+""+month+"-";
		}
		
		if(day < 10) {
			date = date+"0"+day;
		}else {
			date = date+""+day;
		}
		
		
		return appointementService.isAvail(date, id);
	}
	
	public ArrayList<String> next_avail_date(int day, int month, int year, int id) {
		
		boolean avail = false;
		ArrayList<String> dates =new ArrayList<String>();
		int count = 0;
		
		String _day, _month;
		
		while(!avail && count < 10) {	
			if((day == 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 )) || (day == 30 && (month == 4 || month == 6 || month == 9 || month == 10 || month == 11 )) || (day == 29 && month == 2)) {
				day = 1;
				
				if(month == 12) {
					month = 1;
					year++;
				}else {
					month ++;
				}
			}else {
				day ++;
			}
			
			avail = isAvail(day, month, year, id);
			
			if(avail) {
				count ++;
				avail = false;
				
				if(day<10)
					_day = "0" + day;
				else
					_day = "" + day;
				
				if(month<10)
					_month = "0" + month;
				else
					_month = "" + month;
				
				
				dates.add(year + "-" + _month + "-" + _day);
			}
		}
		
		return dates;
	}
	
	public boolean is_avail_agent(User agent, String date) {		
		return appointementService.is_avail_agent(agent.getId(), date);
	}
	
	public boolean is_avail_client(User client, String date) {		
		return appointementService.is_avail_client(client.getId(), date);
	}
	
	@GetMapping("show_appointements")
	public String get_appointements_confirmation(HttpServletRequest request) {
		HttpSession session = request.getSession();
	
		if((session.getAttribute("user") != null) && ( ((User)session.getAttribute("user")).getType().toLowerCase().equals("agent") || ((User)session.getAttribute("user")).getType().toLowerCase().equals("client")) )  {
			int id = ((User)session.getAttribute("user")).getId();
			ArrayList<Appointement> appointements = new ArrayList<Appointement>();
			
			if(((User)session.getAttribute("user")).getType().toLowerCase().equals("agent")) {
				appointements = (ArrayList<Appointement>) appointementService.getAppointementByAgentId(id);
				
			}else {
				appointements = (ArrayList<Appointement>) appointementService.getAppointementByClientId(id);
				
			}
			
			request.setAttribute("appointements", appointements);
			request.setAttribute("type",  ((User)session.getAttribute("user")).getType().toLowerCase());
			
			
			return "show_appointements";
			
		}else {			
			request.setAttribute("login_err", "show");
			request.setAttribute("login_msg", "You have to login.");
			
			return "login";
		}	
	}
	
	@PostMapping("show_appointements")
	public String post_appointements_confirmation(@RequestParam("confirmed") int confirmed, @RequestParam("id") int id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if((session.getAttribute("user") != null) && ( ((User)session.getAttribute("user")).getType().toLowerCase().equals("agent") || ((User)session.getAttribute("user")).getType().toLowerCase().equals("client")) )  {

			if(((User)session.getAttribute("user")).getType().toLowerCase().equals("agent")) 
				 appointementService.confirmAppointementByAgentId(id, confirmed);
			else 
				appointementService.confirmAppointementByClientId(id, confirmed);
	
			ArrayList<Appointement> appointements = new ArrayList<Appointement>();
			
			if(((User)session.getAttribute("user")).getType().toLowerCase().equals("agent")) {
				appointements = (ArrayList<Appointement>) appointementService.getAppointementByAgentId(id);
				
			}else {
				appointements = (ArrayList<Appointement>) appointementService.getAppointementByClientId(id);
				
			}
			
			request.setAttribute("appointements", appointements);
			request.setAttribute("type",  ((User)session.getAttribute("user")).getType().toLowerCase());
			
			
			return "show_appointements";
				
		}else {			
			request.setAttribute("login_err", "show");
			request.setAttribute("login_msg", "You have to login.");
			
			return "login";
		}	
		
	}
	
	@GetMapping("change_appointement")
	public String get_change_appointement(@RequestParam("id") int id, @RequestParam("date") String date, HttpServletRequest request) {
	
		HttpSession session = request.getSession();
		
		if((session.getAttribute("user") != null) && ( ((User)session.getAttribute("user")).getType().toLowerCase().equals("agent") || ((User)session.getAttribute("user")).getType().toLowerCase().equals("client")) )  {
			//Appointement appointement = appointementService.getAppointementById(id);
		
			appointementService.deleteAppointement(id);
			request.setAttribute("success", "The appointement has been changed.");
			return "redirect:/reserve?id="+session.getAttribute("lodgement");
		}else {			
			request.setAttribute("login_err", "show");
			request.setAttribute("login_msg", "You have to login.");
			
			return "login";
		}
	
	}
	
	@GetMapping("save_review")
	public String get_save_review(@RequestParam("id") int id, @RequestParam("review") String review, HttpServletRequest request) {
		return "";
	}
	
	@PostMapping("save_review")
	public void post_save_review(@RequestParam("id") int id, @RequestParam("review") String review, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		if((session.getAttribute("user") != null) && ((User)session.getAttribute("user")).getType().toLowerCase().equals("agent") )  {
			
			appointementService.save_review(id, review);
			
		}else {			
			request.setAttribute("login_err", "show");
			request.setAttribute("login_msg", "You have to login.");
		}
		
	}
	
	
}
