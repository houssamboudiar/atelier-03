package com.realestate.controllers;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.realestate.models.Admin;
import com.realestate.models.Agent;
import com.realestate.models.Appointement;
import com.realestate.models.Client;
import com.realestate.models.Lodgement;
import com.realestate.models.Lodgement_detail;
import com.realestate.models.Notification_details;
import com.realestate.models.Operator;
import com.realestate.services.AdminService;
import com.realestate.services.AgentService;
import com.realestate.services.AppointementService;
import com.realestate.services.ClientService;
import com.realestate.services.LodgementService;
import com.realestate.services.NotificationService;
import com.realestate.services.OperatorService;
import com.realestate.services.ReportsService;

@Controller
public class AccountController {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private AgentService agentService;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private ReportsService reportsService;
	@Autowired
	private AppointementService appointementService;
	@Autowired
	private LodgementService lodgementService;
	@Autowired
	private NotificationService notificationService;
	
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	
	@GetMapping("subscribe_as_client")
	public String get_subscribe(HttpSession session) {
		if(session.getAttribute("client") != null || session.getAttribute("agent") != null || session.getAttribute("operator") != null || session.getAttribute("admin") != null)
			return "redirect:/";
		
		return "subscribe/subscribe_as_client";
	}
	
	@GetMapping("subscribe_as_agent")
	public String get_subscribe_as_agent(HttpSession session) {
		if(session.getAttribute("client") != null || session.getAttribute("operator") != null || session.getAttribute("agent") != null || session.getAttribute("admin") != null)
			return "redirect:/";
		
		return "subscribe/subscribe_as_agent";
	}
	
	@GetMapping("subscribe_as_operator")
	public String get_subscribe_as_operator(HttpSession session) {
		if(session.getAttribute("client") != null || session.getAttribute("operator") != null || 
				session.getAttribute("agent") != null || session.getAttribute("admin") != null)
			return "redirect:/";
		
		return "subscribe/subscribe_as_operator";
	}
	
	@GetMapping("subscribe_as_admin")
	public String get_subscribe_as_admin(HttpSession session, Model model) {
		if(session.getAttribute("admin") != null)
				return "subscribe/subscribe_as_admin";
		
		
		model.addAttribute("type", "model.addAttribute(\"message\", \"You have to login to your admin account.\");");
		model.addAttribute("message", "You have to login to your admin account.");
		return "login/login";
	}
	
	// the client subscription
	@PostMapping("subscribe_as_client")
	public String post_subscribe_client(@RequestParam("username") String username, 
										 @RequestParam("email") String email, 
										 @RequestParam ("password")String password, 
										 @RequestParam("repassword") String repassword, 
										 @RequestParam("name") String name, 
										 @RequestParam("last_name") String last_name, 
										 @RequestParam("profile_pic") MultipartFile profile_pic,
										 @RequestParam("birthdate") String birthdate, 
										 @RequestParam("phone") String phone, 
										 @RequestParam("gender") String gender, 
										 HttpSession session, Model model ) throws ParseException, IOException {
		
		
		String profile_picture_name = "default_profile_picture.jpg";
		
		if(!profile_pic.isEmpty()) {
			String extension = profile_pic.getOriginalFilename().substring(profile_pic.getOriginalFilename().lastIndexOf("."), profile_pic.getOriginalFilename().length());
			Long random = Calendar.getInstance().getTimeInMillis();
			profile_picture_name = random + extension;
		}
			
				
		Client client = new Client(0, email.trim(), password.trim(), username.trim(), name.trim(), last_name.trim(), 
									df.parse(birthdate), gender.trim(), 0, profile_picture_name.trim(), phone.trim());
		String is_valid = is_valid_client(client, repassword);
		try {
			if(is_valid.equals("valid")) {
				
				byte[] profile_pictue = profile_pic.getBytes();
				String path = "/home/amine/workspace-sts/project_1/src/main/resources/static/images/client//";
				
				File uploaded_file = new File(path + profile_picture_name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploaded_file));
				stream.write(profile_pictue);
				stream.close();
				
				if(clientService.client_subscribe(client)) {					
					session.setAttribute("client", client);
					return "redirect:/";
				}
				else {
					model.addAttribute("type", "error");
					model.addAttribute("message", "Sorry. There was an error somewhere, please try again later.");
				}
			}else {
				model.addAttribute("type", "error");
				model.addAttribute("message", is_valid);
			}
		}catch (Exception e) {
			model.addAttribute("type", "error");
			model.addAttribute("message", "Sorry. There was an exception somewhere, please try again later.");
		}
		
		return "subscribe/subscribe_as_client";
	}
	

	// the agent subscription
	@PostMapping("subscribe_as_agent")
	public String post_subscribe_as_agent(@RequestParam("username") String username, 
										   @RequestParam("email") String email,
										   @RequestParam ("password")String password, 
										   @RequestParam("repassword") String repassword, 
										   @RequestParam("name") String name, 
										   @RequestParam("last_name") String last_name, 
										   @RequestParam("profile_pic") MultipartFile profile_pic, 
										   @RequestParam("birthdate") String birthdate, 
										   @RequestParam("phone") String phone, 
										   @RequestParam("gender") String gender, 
										   @RequestParam("locale") String locale,
										   @RequestParam("cv") MultipartFile cv, 
										   HttpSession session, Model model, HttpServletRequest request) throws ParseException {
			
		String profile_picture_name = "default_profile_picture.jpg";
		String cv_name = "no_cv";

		if(!profile_pic.isEmpty()) {
			String extension = profile_pic.getOriginalFilename().substring(profile_pic.getOriginalFilename().lastIndexOf("."), profile_pic.getOriginalFilename().length());
			Long random = Calendar.getInstance().getTimeInMillis();
			profile_picture_name = random + extension;
		}
		
		if(!cv.isEmpty()) {
			String extension = cv.getOriginalFilename().substring(cv.getOriginalFilename().lastIndexOf("."), cv.getOriginalFilename().length());
			cv_name = username + "-" + "cv" + extension;
		}
		
		
		Agent agent = new Agent(0, email.trim(), password.trim(), username.trim(), name.trim(), last_name.trim(), df.parse(birthdate), 
								gender.trim(), locale.trim(), 1, profile_picture_name.trim(), cv_name.trim(), phone.trim());
		
		String is_valid = is_valid_agent(agent, repassword);
		
		try {
			if(is_valid.equals("valid")) {
				
				byte[] profile_pictue = profile_pic.getBytes();
				String path = "/home/amine/workspace-sts/project_1/src/main/resources/static/images/agent/";
				File uploaded_file = new File(path + profile_picture_name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploaded_file));
				stream.write(profile_pictue);
				stream.close();
				
				byte[] byte_cv = cv.getBytes();
				String cv_path = "/home/amine/workspace-sts/project_1/src/main/resources/static/images/agent/cv/";
				File uploaded_cv = new File(cv_path + profile_picture_name);
				BufferedOutputStream cv_stream = new BufferedOutputStream(new FileOutputStream(uploaded_cv));
				cv_stream.write(byte_cv);
				cv_stream.close();
				
				if(agentService.agent_subscribe(agent)) {
					
					session.setAttribute("agent", agent);
					return "redirect:/";
					
				}else {
					model.addAttribute("type", "error");
					model.addAttribute("message", "Sorry. There was an error somewhere, please try again later.");
				}
			}else {
				model.addAttribute("type", "error");
				model.addAttribute("message", is_valid);
			}
		}catch (Exception e) {
			model.addAttribute("type", "error");
			model.addAttribute("message", "Sorry. There was an exception somewhere, please try again later.");
		}
		
		return "subscribe/subscribe_as_agent";
	}
	
	/* The operator subscription */

	@PostMapping("subscribe_as_operator")
	public String post_subscribe_as_operator(@RequestParam("username") String username,
											  @RequestParam("email") String email,
										      @RequestParam ("password")String password, 
										      @RequestParam("repassword") String repassword, 
										      @RequestParam("name") String name, 
										      @RequestParam("last_name") String last_name, 
										      @RequestParam("profile_pic") MultipartFile profile_pic, 
										      @RequestParam("birthdate") String birthdate, 
										      @RequestParam("phone") String phone, 
										      @RequestParam("gender") String gender, 
										      @RequestParam("locale") String locale, 
										      @RequestParam("cv") MultipartFile cv, HttpSession session, Model model) throws ParseException {
		
		String profile_picture_name = "default_profile_picture.jpg";
		String cv_name = "no_cv";

		if(!profile_pic.isEmpty()) {
			String extension = profile_pic.getOriginalFilename().substring(profile_pic.getOriginalFilename().lastIndexOf("."), profile_pic.getOriginalFilename().length());
			Long random = Calendar.getInstance().getTimeInMillis();
			profile_picture_name = random + extension;
		}
		
		if(!cv.isEmpty()) {
			String extension = cv.getOriginalFilename().substring(cv.getOriginalFilename().lastIndexOf("."), cv.getOriginalFilename().length());
			cv_name = username + "-" + "cv" + extension;
		}
		
		Operator operator = new Operator(0, email.trim(), password.trim(), username.trim(), name.trim(), last_name.trim(), df.parse(birthdate), 
								gender.trim(), locale.trim(), 1, profile_picture_name.trim(), cv_name.trim(), phone.trim());
		
		String is_valid = is_valid_operator(operator, repassword);

		
		try {
			if(is_valid.equals("valid")) {
				
				
				byte[] profile_pictue = profile_pic.getBytes();
				String path = "/home/amine/workspace-sts/project_1/src/main/resources/static/images/operator/";
				File uploaded_file = new File(path + profile_picture_name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploaded_file));
				stream.write(profile_pictue);
				stream.close();
				
				byte[] byte_cv = cv.getBytes();
				String cv_path = "/home/amine/workspace-sts/project_1/src/main/resources/static/images/operator/cv/";
				File uploaded_cv = new File(cv_path + profile_picture_name);
				BufferedOutputStream cv_stream = new BufferedOutputStream(new FileOutputStream(uploaded_cv));
				cv_stream.write(byte_cv);
				cv_stream.close();
				
				
				if(operatorService.operator_subscribe(operator)) {
					
					session.setAttribute("operator", operator);
					return "redirect:/";
				}
				else {
					model.addAttribute("type", "error");
					model.addAttribute("message", "Sorry. There was an error somewhere, please try again later.");
				}
				
			}
				
			else {
				model.addAttribute("type", "error");
				model.addAttribute("message", is_valid);
			}
		}catch (Exception e) {
			model.addAttribute("type", "error");
			model.addAttribute("message", "Sorry. There was an exception somewhere, please try again later.");
		}
		
		return "subscribe/subscribe_as_operator";
	}
	
	
	/* The admin subscription */	
	@PostMapping("subscribe_as_admin")
	public String post_subscribe_as_admin(@RequestParam("email") String email, 
										   @RequestParam ("password")String password,
										   @RequestParam("repassword") String repassword, 
										   @RequestParam("name") String name, 
										   @RequestParam("last_name") String last_name, 
										   @RequestParam("profile_pic") MultipartFile profile_pic, 
										   @RequestParam("phone") String phone, HttpSession session, Model model) {
		
		
		
		String profile_picture_name = "default_profile_picture.jpg";
		if(!profile_pic.isEmpty()) {
			String extension = profile_pic.getOriginalFilename().substring(profile_pic.getOriginalFilename().lastIndexOf("."), profile_pic.getOriginalFilename().length());
			Long random = Calendar.getInstance().getTimeInMillis();
			profile_picture_name = random + extension;
		}
		
		Admin admin = new Admin(0, email.trim(), password.trim(), name.trim(), last_name.trim(), profile_picture_name.trim(), phone.trim());
		String is_valid = is_valid_admin(admin, repassword);
		try {
			if(is_valid.equals("valid")) {
				
				byte[] profile_pictue = profile_pic.getBytes();
				String path = "/home/amine/workspace-sts/project_1/src/main/resources/static/images/admin/";
				File uploaded_file = new File(path + profile_picture_name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploaded_file));
				stream.write(profile_pictue);
				stream.close();
				
				if(adminService.admin_subscribe(admin)) {
					
					session.setAttribute("admin", admin);
					return "redirect:/";
				}else {
					model.addAttribute("type", "error");
					model.addAttribute("message", "Sorry. There was an error somewhere, please try again later.");
				}
			
		}else {
				model.addAttribute("type", "error");
				model.addAttribute("message", is_valid);
			}
			
		}catch (Exception e) {
			model.addAttribute("type", "error");
			model.addAttribute("message", "Sorry. There was an exception somewhere, please try again later.");
		}
		
		return "subscribe/subscribe_as_admin";
	}
	
	/* ************************************************************************************************************************************* */
	
	public String  is_valid_client(Client client, String repassword) {
		if(is_valid(client.getUsername(), client.getEmail(),client.getName(), client.getLast_name(), client.getPassword(), 
				client.getPhone(), repassword).equals("valid")) {
			
			if(client_email_exists(client.getEmail()))
				return "This email is already assained to an other account.";
				 
			return "valid";
		}else {
			return is_valid(client.getUsername(), client.getEmail(),client.getName(), client.getLast_name(), client.getPassword(), 
					client.getPhone(), repassword);
		}
	}
	
	public String  is_valid_client_not_finished(Client client, String repassword) {
		if(is_valid(client.getUsername(), client.getEmail(),client.getName(), client.getLast_name(), client.getPassword(), 
				client.getPhone(), repassword).equals("valid")) {
			
			if(clientService.is_finished_subscribe(client.getEmail()))
				return "This email is already assained to an other account.";
				 
			return "valid";
		}else {
			return is_valid(client.getUsername(), client.getEmail(),client.getName(), client.getLast_name(), client.getPassword(), 
					client.getPhone(), repassword);
		}
	}
	
	
	public String  is_valid_agent(Agent agent, String repassword) {
		if(is_valid(agent.getUsername(), agent.getEmail(),agent.getName(), agent.getLast_name(), agent.getPassword(), 
				agent.getPhone(), repassword).equals("valid")) {
			
			if(agent_email_exists(agent.getEmail()))
				return "This email is already assained to an other account.";
				
			return "valid";
		}else {
			return is_valid(agent.getUsername(), agent.getEmail(),agent.getName(), agent.getLast_name(), agent.getPassword(), 
					agent.getPhone(), repassword);
		}
	}
	
	
	public String  is_valid_operator(Operator operator, String repassword) {
		if(is_valid(operator.getUsername(), operator.getEmail(), operator.getName(), operator.getLast_name(), 
			operator.getPassword(), operator.getPhone(), repassword).equals("valid")) {
			if(operator_email_exists(operator.getEmail()))
				return "This email is already assained to an other account.";
	
			return "valid";
		}else {
			return is_valid(operator.getUsername(), operator.getEmail(), operator.getName(), operator.getLast_name(), 
					operator.getPassword(), operator.getPhone(), repassword);
		}
	}
	
	public String  is_valid_admin(Admin admin, String repassword) {
		if(is_valid("username", admin.getEmail(), admin.getName(), admin.getLast_name(), 
				admin.getPassword(), admin.getPhone(), repassword).equals("valid")) {
			
			if(admin_email_exists(admin.getEmail()))
				return "This email is already assained to an other account.";
			
			//the cv and the loacle validation 
			return "valid";
		}else {
			return is_valid("a_valid_username", admin.getEmail(), admin.getName(), admin.getLast_name(), 
					admin.getPassword(), admin.getPhone(), repassword);
		}
	}
	
	

		
	public String is_valid(String username, String email, String name, String last_name, String password, 
						    String phone, String repassword) {
		
		if(username.trim().length() == 0)
			return "The username is required.";	
		
		if(email.trim().length() == 0)
			return "The email is required.";
		
		if(password.trim().length() == 0)
			return "The password is required.";
		
		if(phone.trim().length() == 0)
			return "The phone number is required.";
		
		if(name.trim().length() == 0)
			return "Your name is required.";
		
		if(repassword.trim().length() == 0)
			return "The password confirmation is required.";
		
		if(last_name.trim().length() == 0)
			return "The last name is required.";
		
		if(!password.trim().equals(repassword.trim()))
			return "The password does not match with its confirmation.";
		
			
		if( !is_accepted("[A-Za-z0-9_]{4,12}", username.trim()))
			return "Invalid username. It must contains only characters and digets.";
		
		if( !is_accepted("[A-Za-z0-9.-_%]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,4}", email.trim())) 
			return "Invalid email.";
		
		if( !is_accepted("[A-Za-z0-9.-_]{6,20}", password.trim())) 
			return "Invalid passowrd. It must be more then 6 characters and digets.";
		
		if( !is_accepted("[0-9\\+]{8,14}", phone.trim())) 
			return "Invalid phone number.";
		
		if( !is_accepted("[A-Za-z]{2,20}", name.trim())) 
			return "Invalid name. It must contains only characters.";
		
		if( !is_accepted("[A-Za-z]{2,20}", last_name.trim())) 
			return "Invalid lastname. It must contains only characters.";
						
		return "valid";
	}
	
	public boolean is_accepted(String the_regexp, String str) {
		Pattern pattern = Pattern.compile(the_regexp);
		Matcher matcher = pattern.matcher(str);
		
		while(matcher.find()) {
			if(matcher.group().trim().length() == str.trim().length()) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean client_email_exists(String email) {
		if(clientService.client_email_exists(email))
			return true;
		else
			return false;
	}
	
	public boolean agent_email_exists(String email) {
		if(agentService.agent_email_exists(email))
			return true;
		else
			return false;
	}
	
	public boolean operator_email_exists(String email) {
		if(operatorService.operator_email_exists(email))
			return true;
		else
			return false;
	}
	
	public boolean admin_email_exists(String email) {
		if(adminService.admin_email_exists(email))
			return true;
		else
			return false;
	}
	
	
	/* the operator add client functionality */
	
	@GetMapping("handel_client_account")
	public String get_add_client(HttpSession session, Model model) throws ParseException {
		
		if((Operator)session.getAttribute("operator") != null) {
			
			model.addAttribute("operator", session.getAttribute("operator"));
			
			List<Notification_details> notifications = reportsService.get_reports(session);
			session.setAttribute("notifications", notifications);
			
			int notification_nbr = 0;
			for(Notification_details notif : notifications) {
				if(!notif.isViewed())
					notification_nbr ++ ;
			}
			
			model.addAttribute("notifications", notifications);
			model.addAttribute("notification_nbr", notification_nbr);
			if(session.getAttribute("reporter") != null) {
				model.addAttribute("reporter",session.getAttribute("reporter"));
			}
			
			return "subscribe/handel_client_account"; 
		}else {
			
			session.setAttribute("url", "handel_client_account");
			session.setAttribute("type", "error");
			session.setAttribute("message", "You have to login.");
			return "redirect:/login";
		}
	}
	
	@PostMapping("add_client")
	public String post_add_client(		 @RequestParam("email") String email, 
										 @RequestParam ("password")String password, 
										 @RequestParam("repassword") String repassword, 
										 HttpSession session ) throws ParseException {
		
		
				
		if(session.getAttribute("operator") != null) {
			
			Client client = new Client(0, email.trim(), password.trim(), "added_by_operator", "", "", df.parse("0000-00-00"),"", 0, "", "");
			
			try {
				
				if(!password.equals(repassword) || client_email_exists(email)) {
					
					if(client_email_exists(email)) {
						session.setAttribute("type", "error");
						session.setAttribute("message", "This email is allredy assocaited to a client account.");
					}else {
						session.setAttribute("type", "error");
						session.setAttribute("message", "This password and its confirmation are not identical.");
					}
					
				}else {
				
					if(clientService.client_subscribe(client)) {
						session.setAttribute("type", "success");
						session.setAttribute("message", "The client account has been successfuly created.");
					}
					else {
						session.setAttribute("type", "error");
						session.setAttribute("message", "Sorry, There was an error somewhere, Try again later.");
					}
				}
				
			}catch (Exception e) {
				session.setAttribute("type", "error");
				session.setAttribute("message", "Sorry, There was an error somewhere, Try again later.");
				System.out.println("There was an error in the subscribeController. "+e.getMessage());
			}
			
			session.setAttribute("_url", "subscribe/handel_client_account");
			
		}else {
			session.setAttribute("type", "error");
			session.setAttribute("message", "Access deiend.");
		}
		
		return "redirect:/";
	}
	
	@PostMapping("remove_client")
	public String post_remove_client(@RequestParam("email") String email, HttpSession session) {
		
		if(session.getAttribute("operator") != null) {
			
			if(client_email_exists(email)) {
				if(clientService.remove_client_by_email(email)) {
					session.setAttribute("type", "success");
					session.setAttribute("message", "The client account has been successfuly removed.");
				}else {
					session.setAttribute("type", "error");
					session.setAttribute("message", "Sorry. There was an error somewhere try again later.");
				}
			}else {
				session.setAttribute("type", "error");
				session.setAttribute("message", "This email is not assocaited to any client account.");
			}

			session.setAttribute("_url", "subscribe/handel_client_account");
		}else {
			session.setAttribute("type", "error");
			session.setAttribute("message", "Access deiend.");
		}
		
		return "redirect:/";
	}
	
	@PostMapping("block_client")
	public String post_block_client(@RequestParam("email") String email, HttpSession session) {
		
		if(session.getAttribute("operator") != null) {
			
			if(client_email_exists(email)) {
				if(clientService.get_client_by_email(email).getBlocked() == 0) {
					if(clientService.block_client_by_email(email)) {
						session.setAttribute("type", "success");
						session.setAttribute("message", "The client account has been successfuly blocked.");
					}else {
						session.setAttribute("type", "error");
						session.setAttribute("message", "Sorry. There was an error somewhere try again later.");
					}
				}else {
					session.setAttribute("type", "error");
					session.setAttribute("message", "This account is already blocked.");
				}

			}else {
				session.setAttribute("type", "error");
				session.setAttribute("message", "This email is not assocaited to any client account.");
			}
			
			session.setAttribute("_url", "subscribe/handel_client_account");
		}else {
			session.setAttribute("type", "error");
			session.setAttribute("message", "Access deiend.");
		}
		
		return "redirect:/";
	}
	
	
	
	
	@GetMapping("finish_client_subscription")
	public String get_finish_client_subscription(HttpSession session) {
		if(session.getAttribute("client") != null ) {
			session.setAttribute("_url", "subscribe/finish_client_subscription");
		}
		return "redirect:/";
	}
	
	@PostMapping("finish_client_subscription")
	public String post_finish_client_subscription(@RequestParam("username") String username, @RequestParam ("password")String password, 
			 @RequestParam("repassword") String repassword, 
			 @RequestParam("name") String name, 
			 @RequestParam("last_name") String last_name, 
			 @RequestParam("profile_pic") MultipartFile profile_pic, 
			 @RequestParam("birthdate") String birthdate, 
			 @RequestParam("phone") String phone, 
			 @RequestParam("gender") String gender, 
			 HttpSession session, Model model ) throws ParseException {

		
		String profile_picture_name = "default_profile_picture.jpg";
		
		if(!profile_pic.isEmpty()) {
			String extension = profile_pic.getOriginalFilename().substring(profile_pic.getOriginalFilename().lastIndexOf("."), profile_pic.getOriginalFilename().length());
			Long random = Calendar.getInstance().getTimeInMillis();
			profile_picture_name = random + extension;
		}

		
		Client client = new Client(0, ((Client)session.getAttribute("client")).getEmail(), password.trim(), username.trim(), name.trim(), last_name.trim(), 
									df.parse(birthdate), gender.trim(), 0, profile_picture_name.trim(), phone.trim());
		
		String is_valid = is_valid_client_not_finished(client, repassword);

		try {
			if(is_valid.equals("valid")) {
				
				byte[] profile_pictue = profile_pic.getBytes();
				String path = "/home/amine/workspace-sts/project_1/src/main/resources/static/images/client/";

				File uploaded_file = new File(path + profile_picture_name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploaded_file));
				stream.write(profile_pictue);
				stream.close();
				
				if(clientService.client_finish_subscribe(client)) { 
					
					session.setAttribute("client", client);
					session.removeAttribute("not_finished");
					return "redirect:/";
					
				}else {
					session.setAttribute("type", "error");
					session.setAttribute("message", "Sorry, There was an error somewhere, Try again later.");
				
					session.setAttribute("_url", "subscribe/finish_client_subscription");
				}
			}else {
				session.setAttribute("type", "error");
				session.setAttribute("message", is_valid);
				
				session.setAttribute("_url", "subscribe/finish_client_subscription");
			}
		}catch (Exception e) {
			session.setAttribute("type", "error");
			session.setAttribute("message", "Sorry, There was an error somewhere, Try again later.");
			
			session.setAttribute("_url", "subscribe/finish_client_subscription");
		}
		
		return "redirect:/";
		
	}
		
	
	@SuppressWarnings("deprecation")
	@GetMapping("client_profile/{id}")
	public String get_client_profile(@PathVariable("id") int id_client, HttpSession session, Model model) throws ParseException {
		
		if(session.getAttribute("client") != null || session.getAttribute("agent") != null || session.getAttribute("operator") != null || session.getAttribute("admin") != null) {
		
			model.addAttribute("is_not_logged", false);
			
			if(session.getAttribute("client") != null){
			
				List<Notification_details> notifications = notificationService.get_notifications(session);
				int notification_nbr = 0;
				
				for(Notification_details notif : notifications) {
					if(!notif.isViewed())
						notification_nbr ++ ;
				}
				
				model.addAttribute("notification_nbr", notification_nbr);
				model.addAttribute("notifications", notifications);
				
				model.addAttribute("is_client", true);
				model.addAttribute("client", session.getAttribute("client"));
				
				if(((Client)session.getAttribute("client")).getId() == id_client) {
					return "edit/my_client_profile";
				}
				
			}else {
				model.addAttribute("is_client", false);
			}
			
			if(session.getAttribute("agent") != null){
								
				List<Notification_details> notifications = notificationService.get_notifications(session);
				int notification_nbr = 0;
				
				for(Notification_details notif : notifications) {
					if(!notif.isViewed())
						notification_nbr ++ ;
				}
				
				model.addAttribute("notification_nbr", notification_nbr);
				model.addAttribute("notifications", notifications);
				
				model.addAttribute("is_agent", true);
				model.addAttribute("agent", session.getAttribute("agent"));
				
			}else {
				model.addAttribute("is_agent", false);
			}
			
			if(session.getAttribute("operator") != null){
				
				model.addAttribute("operator", session.getAttribute("operator"));
				
				List<Notification_details> notifications = reportsService.get_reports(session);
				session.setAttribute("notifications", notifications);
				
				int notification_nbr = 0;
				for(Notification_details notif : notifications) {
					if(!notif.isViewed())
						notification_nbr ++ ;
				}
				
				model.addAttribute("notifications", notifications);
				model.addAttribute("notification_nbr", notification_nbr);
				model.addAttribute("is_operator", true);
				model.addAttribute("operator", session.getAttribute("operator"));
				
			}else {
				model.addAttribute("is_operator", false);
			}


			if(session.getAttribute("admin") != null){
				
				model.addAttribute("admin", session.getAttribute("admin"));
				model.addAttribute("is_admin", true);
				
			}else {
				model.addAttribute("is_admin", false);
			}
			
			Client client = clientService.get_client_by_id(id_client);
			if(client != null && client.getBlocked() != 1){
				
				int age = (new Date().getYear()) - client.getBirthdate().getYear();
				model.addAttribute("age", age);
				model.addAttribute("profile_client", client);
				return "visite/client_profile";
			}else {
				
				session.setAttribute("looking_for", "client");
				return "redirect:/error";
				
			}
			
		}else {

			model.addAttribute("is_admin", false);
			model.addAttribute("is_agent", false);
			model.addAttribute("is_client", false);
			model.addAttribute("is_operator", false);
			model.addAttribute("is_not_logged", true);
			
			Client client = clientService.get_client_by_id(id_client);
			if(client != null && client.getBlocked() != 1){
				
				int age = (new Date().getYear()) - client.getBirthdate().getYear();
				model.addAttribute("age", age);
				model.addAttribute("profile_client", client);
				return "visite/client_profile";
			}else {
				
				session.setAttribute("looking_for", "client");
				return "redirect:/error";
				
			}
			
		}
	}
	
	
	@SuppressWarnings("deprecation")
	@GetMapping("agent_profile/{id}")
	public String get_agent_profile(@PathVariable("id") int id_agent, HttpSession session, Model model) throws ParseException {
		
		if(session.getAttribute("client") != null || session.getAttribute("agent") != null || session.getAttribute("operator") != null || session.getAttribute("admin") != null) {
		
			model.addAttribute("is_not_logged", false);
			
			if(session.getAttribute("client") != null){
			
				List<Notification_details> notifications = notificationService.get_notifications(session);
				int notification_nbr = 0;
				
				for(Notification_details notif : notifications) {
					if(!notif.isViewed())
						notification_nbr ++ ;
				}
				
				model.addAttribute("notification_nbr", notification_nbr);
				model.addAttribute("notifications", notifications);
				
				model.addAttribute("is_client", true);
				model.addAttribute("client", session.getAttribute("client"));
				
			}else {
				model.addAttribute("is_client", false);
			}
			
			if(session.getAttribute("agent") != null){
				
				List<Notification_details> notifications = notificationService.get_notifications(session);
				int notification_nbr = 0;
				
				for(Notification_details notif : notifications) {
					if(!notif.isViewed())
						notification_nbr ++ ;
				}
				
				model.addAttribute("notification_nbr", notification_nbr);
				model.addAttribute("notifications", notifications);
				
				model.addAttribute("is_agent", true);
				model.addAttribute("agent", session.getAttribute("agent"));
				
				if(((Agent)session.getAttribute("agent")).getId() == id_agent) {
					return "edit/my_agent_profile";
				}
				
				
			}else {
				model.addAttribute("is_agent", false);
			}
			
			if(session.getAttribute("operator") != null){
				
				
				model.addAttribute("operator", session.getAttribute("operator"));
				
				List<Notification_details> notifications = reportsService.get_reports(session);
				session.setAttribute("notifications", notifications);
				
				int notification_nbr = 0;
				for(Notification_details notif : notifications) {
					if(!notif.isViewed())
						notification_nbr ++ ;
				}
				
				model.addAttribute("notifications", notifications);
				model.addAttribute("notification_nbr", notification_nbr);
				model.addAttribute("is_operator", true);
				model.addAttribute("operator", session.getAttribute("operator"));
				
			}else {
				model.addAttribute("is_operator", false);
			}
			
			if(session.getAttribute("admin") != null){
				
				model.addAttribute("admin", session.getAttribute("admin"));
				model.addAttribute("is_admin", true);
				
			}else {
				model.addAttribute("is_admin", false);
			}
			
			Agent agent = agentService.get_agent_by_id(id_agent);
			if(agent != null && agent.getBlocked() != 1){
								
				int age = (new Date().getYear()) - agent.getBirthdate().getYear();
				model.addAttribute("age", age);
				model.addAttribute("profile_agent", agent);
				return "visite/agent_profile";
				
			}else {
				
				session.setAttribute("looking_for", "agent");
				return "redirect:/error";
				
			}
			
		}else {
			
			model.addAttribute("is_admin", false);
			model.addAttribute("is_agent", false);
			model.addAttribute("is_client", false);
			model.addAttribute("is_operator", false);
			model.addAttribute("is_not_logged", true);
			
			Agent agent = agentService.get_agent_by_id(id_agent);
			if(agent != null && agent.getBlocked() != 1){
								
				int age = (new Date().getYear()) - agent.getBirthdate().getYear();
				model.addAttribute("age", age);
				model.addAttribute("profile_agent", agent);

				return "visite/agent_profile";
				
			}else {
				
				session.setAttribute("looking_for", "agent");
				return "redirect:/error";
				
			}
						
		}
	}
	
	
	
	@GetMapping("lodgement_details/{id}")
	public String get_appartement_details(@PathVariable("id")int id_lodgement,  Model model, HttpSession session) throws ParseException {
		
		
		Lodgement lodgement = lodgementService.get_lodgements_by_id(id_lodgement);
		
		
		if(session.getAttribute("client") != null || session.getAttribute("agent") != null || session.getAttribute("operator") != null || session.getAttribute("admin") != null) {
			
			model.addAttribute("is_not_logged", false);
			
			if(session.getAttribute("client") != null){
			
				List<Notification_details> notifications = notificationService.get_notifications(session);
				int notification_nbr = 0;
				
				for(Notification_details notif : notifications) {
					if(!notif.isViewed())
						notification_nbr ++ ;
				}
				
				model.addAttribute("notification_nbr", notification_nbr);
				model.addAttribute("notifications", notifications);
				
				model.addAttribute("is_client", true);
				model.addAttribute("client", session.getAttribute("client"));
				
				if(session.getAttribute("type") != null && session.getAttribute("message") != null ) {
					
					model.addAttribute("type", session.getAttribute("type"));
					model.addAttribute("message", session.getAttribute("message"));
					
					session.removeAttribute("message");
					session.removeAttribute("type");
				}
				
				
			}else {
				model.addAttribute("is_client", false);
			}
			
			if(session.getAttribute("agent") != null){
				
				List<Notification_details> notifications = notificationService.get_notifications(session);
				int notification_nbr = 0;
				
				for(Notification_details notif : notifications) {
					if(!notif.isViewed())
						notification_nbr ++ ;
				}
				
				model.addAttribute("notification_nbr", notification_nbr);
				model.addAttribute("notifications", notifications);
				
				model.addAttribute("is_agent", true);
				model.addAttribute("agent", session.getAttribute("agent"));
				
				
			}else {
				model.addAttribute("is_agent", false);
			}
			
			if(session.getAttribute("operator") != null){
				
				
				model.addAttribute("operator", session.getAttribute("operator"));
				
				List<Notification_details> notifications = reportsService.get_reports(session);
				session.setAttribute("notifications", notifications);
				
				int notification_nbr = 0;
				for(Notification_details notif : notifications) {
					if(!notif.isViewed())
						notification_nbr ++ ;
				}
				
				model.addAttribute("notifications", notifications);
				model.addAttribute("notification_nbr", notification_nbr);
				model.addAttribute("is_operator", true);
				model.addAttribute("operator", session.getAttribute("operator"));
				
			}else {
				model.addAttribute("is_operator", false);
			}
			
			if(session.getAttribute("admin") != null){
				
				model.addAttribute("admin", session.getAttribute("admin"));
				model.addAttribute("is_admin", true);
				
			}else {
				model.addAttribute("is_admin", false);
			}
			
			
			if(lodgement != null) {
				
				List<Appointement> appois = appointementService.get_Appointements_by_id_lodgement(id_lodgement);
				
				List<Lodgement_detail> lodgement_details = new 	ArrayList<Lodgement_detail>();
				String half;
				
				for(Appointement appoi:appois) {
					
					if(appoi.getFirst_half() == 1)
						half = "Morning";
					else
						half = "Evening";
					
					if(appoi.getReview() != null && !appoi.getReview().equals("")) {
					
						lodgement_details.add(
								new Lodgement_detail(
										(clientService.get_client_by_id(appoi.getId_client())).getProfile_pic(),
										(clientService.get_client_by_id(appoi.getId_client())).getUsername(),
										appoi.getDate(),
										half, appoi.getReview()
								));
						
						if(lodgement_details.size() == 25)
							break;
					}	
					
					
				}
				
				
				
				model.addAttribute("lodgement", lodgement);
				
				model.addAttribute("lodgement_pics", lodgement.getPics().split(","));
			
				model.addAttribute("lodgement_details", lodgement_details);
				
				if( !(session.getAttribute("type") == null) && !(session.getAttribute("message") == null) ) {
					
					model.addAttribute("type", session.getAttribute("type"));
					model.addAttribute("message", session.getAttribute("message"));
					
					session.removeAttribute("type");
					session.removeAttribute("message");
				}
					
				
				return "visite/lodgement_details";
		
			}else {
			
				session.setAttribute("looking_for", "lodgement");
				return "redirect:/error";
			
			}
			
			
		
		}else {
			
			model.addAttribute("is_admin", false);
			model.addAttribute("is_agent", false);
			model.addAttribute("is_client", false);
			model.addAttribute("is_operator", false);
			model.addAttribute("is_not_logged", true);
			
			if(lodgement != null) {
				
				List<Appointement> appois = appointementService.get_Appointements_by_id_lodgement(id_lodgement);
				
				List<Lodgement_detail> lodgement_details = new 	ArrayList<Lodgement_detail>();
				String half;
				
				for(Appointement appoi:appois) {
					
					if(appoi.getFirst_half() == 1)
						half = "Morning";
					else
						half = "Evening";
					
					if(appoi.getReview() != null && !appoi.getReview().equals("")) {
					
						lodgement_details.add(
								new Lodgement_detail(
										(clientService.get_client_by_id(appoi.getId_client())).getProfile_pic(),
										(clientService.get_client_by_id(appoi.getId_client())).getUsername(),
										appoi.getDate(),
										half, appoi.getReview()
								));
						
						if(lodgement_details.size() == 25)
							break;
					}	
					
					
				}
				
				model.addAttribute("lodgement", lodgement);
				
				model.addAttribute("lodgement_pics", lodgement.getPics().split(","));
			
				model.addAttribute("lodgement_details", lodgement_details);
				
				if( !(session.getAttribute("type") == null) && !(session.getAttribute("message") == null) ) {
					
					model.addAttribute("type", session.getAttribute("type"));
					model.addAttribute("message", session.getAttribute("message"));
					
					session.removeAttribute("type");
					session.removeAttribute("message");
				}
					
				return "visite/lodgement_details";
		
			}else {
			
				session.setAttribute("looking_for", "lodgement");
				return "redirect:/error";
			
			}
			
		}
		
		
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
