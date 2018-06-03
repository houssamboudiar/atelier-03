package com.realestate.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.realestate.models.Notification_details;
import com.realestate.services.AdminService;
import com.realestate.services.AgentService;
import com.realestate.services.ClientService;
import com.realestate.services.NotificationService;
import com.realestate.services.OperatorService;

@Controller
public class RoutingController {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private AgentService agentService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private NotificationService notificationService;

	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	@GetMapping("/")
	public String get_home(HttpSession session, Model model, HttpServletRequest request) throws ParseException {

		if(session.getAttribute("logout") != null) {
			session.invalidate();
			return "redirect:/";
		}
		
		if(request.getCookies() != null && session.getAttribute("client") == null && session.getAttribute("operator") == null && session.getAttribute("agent") == null && session.getAttribute("admin") == null) {
			for(Cookie k : request.getCookies()) {
				if(k.getName().equals("logged_in") && !k.getValue().equals("")) {
					
					String user_type = k.getValue().substring(0, k.getValue().indexOf("-"));
					int user_id = Integer.parseInt(k.getValue().substring(k.getValue().indexOf("-")+1, k.getValue().length()));
					
					if(user_type.equals("client")) {
						session.setAttribute(user_type, clientService.get_client_by_id(user_id));
					}else {
						if(user_type.equals("agent")) {
							session.setAttribute(user_type, agentService.get_agent_by_id(user_id));
						}else {
							if(user_type.equals("operator")) {
								session.setAttribute(user_type, operatorService.get_operator_by_id(user_id));
							}else {
								if(user_type.equals("admin")) {
									session.setAttribute(user_type, adminService.get_admin_by_id(user_id));
								}
							}
						}
					}
				}
			}
		}
		
		if(session.getAttribute("client") != null) {
			
			List<Notification_details> notifications = notificationService.get_notifications(session);
			session.setAttribute("notifications", notifications);
			
			int notification_nbr = 0;
			
			for(Notification_details notif : notifications) {
				if(!notif.isViewed())
					notification_nbr ++ ;
			}

			if(session.getAttribute("url") != null) {
				String url = (String) session.getAttribute("url");
				session.removeAttribute("url");
				
				return "redirect:/"+ url;
			}else {
								
				model.addAttribute("notification_nbr", notification_nbr);
				model.addAttribute("notifications", session.getAttribute("notifications"));
				
				session.removeAttribute("notifications");
				
				if(session.getAttribute("_url") != null) {
					String _url = (String)session.getAttribute("_url");
					session.removeAttribute("_url");
					
					if(session.getAttribute("type") != null && session.getAttribute("message") != null) {
						model.addAttribute("type", session.getAttribute("type"));
						model.addAttribute("message", session.getAttribute("message"));
						
						session.removeAttribute("type");
						session.removeAttribute("message");
					}
					return _url;
				}else {
					
					if(session.getAttribute("not_finished") != null) {
						
						if(session.getAttribute("type") != null && session.getAttribute("message") != null) {
							model.addAttribute("type", session.getAttribute("type"));
							model.addAttribute("message", session.getAttribute("message"));
							
							session.removeAttribute("type");
							session.removeAttribute("message");
						}
						
						return "subscribe/finish_client_subscription";
					}else{
						session.removeAttribute("not_finished");
						
						if(session.getAttribute("first_login") != null) {
							model.addAttribute("first_login", true);
							session.removeAttribute("first_login");
						}
						
						model.addAttribute("client", session.getAttribute("client"));
						return "homepage/client";
					}
				}
			}
		}else {
			
			if(session.getAttribute("agent") != null) {
				
				List<Notification_details> notifications = notificationService.get_notifications(session);
				session.setAttribute("notifications", notifications);
				
				int notification_nbr = 0;
				
				for(Notification_details notif : notifications) {
					if(!notif.isViewed())
						notification_nbr ++ ;
				}

				if(session.getAttribute("url") != null) {
					
					String url = (String) session.getAttribute("url");
					session.removeAttribute("url");
					
					return "redirect:/"+ url;
					
				}else {
					String _url;
					
					model.addAttribute("notification_nbr", notification_nbr);
					
					if(session.getAttribute("notifications") != null) {
						model.addAttribute("notifications", session.getAttribute("notifications"));
						session.removeAttribute("notifications");
					}
					
					if(session.getAttribute("_url") != null) {
						_url = (String) session.getAttribute("_url");
						session.removeAttribute("_url");
					}else {
						model.addAttribute("agent", session.getAttribute("agent"));
						_url = "redirect:/my_appointements";
					}
					
					
					return _url;
				}
				
				
			}else {
				if(session.getAttribute("operator") != null) {
					
					List<Notification_details> notifications = notificationService.get_notifications(session);
					
					int notification_nbr = 0;
					for(Notification_details notif : notifications) {
						if(!notif.isViewed())
							notification_nbr ++ ;
					}
					
					session.setAttribute("notifications", notifications);
					session.setAttribute("notification_nbr", notification_nbr);
					session.setAttribute("operator", session.getAttribute("operator"));

					if(session.getAttribute("url") != null) {
						String url = (String) session.getAttribute("url");
						session.removeAttribute("url");
						
						return "redirect:/"+ url;
					}else {
						
						String _url = "";
						
						if(session.getAttribute("reporter") != null) {
							model.addAttribute("reporter",session.getAttribute("reporter"));
						}
						
						if(session.getAttribute("type") != null && session.getAttribute("message") != null) {
							model.addAttribute("type", session.getAttribute("type"));
							model.addAttribute("message", session.getAttribute("message"));
							
							session.removeAttribute("type");
							session.removeAttribute("message");
						}
						
						if(session.getAttribute("_url") != null) {
							_url = (String) session.getAttribute("_url");
							session.removeAttribute("_url");							
						}else {
							model.addAttribute("operator", session.getAttribute("operator"));
							_url = "homepage/operator";
						}
						
						model.addAttribute("notifications", notifications);
						model.addAttribute("notification_nbr", notification_nbr);
						model.addAttribute("operator", session.getAttribute("operator"));
						
						return _url;
						
					}
					
				}else {
					if(session.getAttribute("admin") != null) {
						model.addAttribute("admin", session.getAttribute("admin"));
						return "admin/general";
					
					}else {

						if(session.getAttribute("type") != null && session.getAttribute("message") != null) {
							model.addAttribute("type", session.getAttribute("type"));
							model.addAttribute("message", session.getAttribute("message"));
							
							session.removeAttribute("type");
							session.removeAttribute("message");
						}

						return "index";
					}
				}
			}
		}
	}
	
}
