package com.codingdojo.Display.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	@GetMapping("/")
	public String home() { 
		return "index.jsp";
	}
	
	@GetMapping("/date")
	public String currentDate(Model model) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMM d, yyyy");
	    String formattedDate = dateFormat.format(new Date());
	    model.addAttribute("formattedDate", formattedDate);
		return "date.jsp";
	}
	
	@GetMapping("/time")
	public String currentTime(Model model) {
	    SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
	    String formattedTime = timeFormat.format(new Date());
	    model.addAttribute("formattedTime", formattedTime);
		return "time.jsp";
	}

}
