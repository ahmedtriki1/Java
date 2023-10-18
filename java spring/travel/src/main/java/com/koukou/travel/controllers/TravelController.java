package com.koukou.travel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.koukou.travel.models.Travel;
import com.koukou.travel.services.TravelService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class TravelController {
	@Autowired
	private TravelService travelServ;
	
	// DISPLAY ROUTE - READ ALL - Create
		@GetMapping("/expenses")
		public String home(@ModelAttribute("travel") Travel travel,
				Model m) {
			List<Travel> allThetravel = travelServ.allTravels();
			m.addAttribute("travelsList", allThetravel);
			return "expenses.jsp";
		}
		
		// ACTION ROUTE - Process Form
		@PostMapping("/expenses")
		public String createBook(@Valid @ModelAttribute("travel") Travel travel, BindingResult result,
								Model m,
								HttpSession session) {
			
			if (result.hasErrors()) {
				List<Travel> allThetravel = travelServ.allTravels();
				m.addAttribute("travelsList", allThetravel);
				return "expenses.jsp";
			} else {
				// save the book
			Travel newtravel = travelServ.createTravel(travel);

			return "redirect:/expenses";
			}
			
		}
		
		// READ ONE - Display Route
		@GetMapping("/expenses/{id}")
		public String showTravel(@PathVariable("id") Long id, Model model) {
		    Travel travel = travelServ.findTravel(id);

		    if (travel == null) {
		        // Handle case where travel entry is not found
		        return "errorPage"; // You can replace this with the actual error handling view
		    }

		    model.addAttribute("travel", travel);
		    return "show.jsp"; // Change this to match your JSP view name
		}
		
		// Display Route - Edit form
		
		@GetMapping("expenses/{id}/edit")
		public String editPage(@PathVariable("id") Long id, Model model
				) {
			
			// find that book with provided id
			Travel thisTravel = travelServ.findTravel(id);
			
			// pass thisBook to the jsp page 
			model.addAttribute("travel",thisTravel);
			
			return "edit.jsp";
		}
		
		@PutMapping("/expenses/{id}/edit")
		public String update(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
			if (result.hasErrors()) {
				return "edit.jsp";
			} else {
				travelServ.updateTravel(travel);
				return "redirect:/expenses";
			}
		}
		
		// DELETE
		
		@DeleteMapping("/expenses/{id}")
		public String delete(@PathVariable("id") Long id) {
			travelServ.deleteTravel(id);
			return "redirect:/expenses";
		}
		
}

