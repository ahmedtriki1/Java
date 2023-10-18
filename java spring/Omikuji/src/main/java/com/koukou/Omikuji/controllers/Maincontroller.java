package com.koukou.Omikuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class Maincontroller {

	@RequestMapping("/form")
	public String form() {
		return "form.jsp";
		}
	
	// === ACTION ROUTE ===
			@RequestMapping(value="/processForm", method=RequestMethod.POST)
			public String process(@RequestParam("numbrer") int numbrer,
									@RequestParam("city") String city,
									@RequestParam("person") String person,
									@RequestParam("hobby") String hobby,
									@RequestParam("type") String type,
									@RequestParam("something") String something,
									HttpSession session) {
				
				
				session.setAttribute("numbrer", numbrer);
				session.setAttribute("city", city);
				session.setAttribute("person", person);
				session.setAttribute("hobby", hobby);
				session.setAttribute("type", type);
				session.setAttribute("something", something);

				
				return "redirect:/msg";
			}
			
			// === ACTION ROUTE ===

			@RequestMapping("/msg")
			public String msg() {
				
				
				return "msg.jsp";
			}
	}

