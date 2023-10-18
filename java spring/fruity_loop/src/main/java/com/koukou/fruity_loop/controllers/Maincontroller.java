package com.koukou.fruity_loop.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Maincontroller {
	@RequestMapping("/")
	public String fruit(Model model) {
        ArrayList<Item> fruitList = new ArrayList<Item>();
		
        fruitList.add(new Item ("Kiwi", 1.5));
        fruitList.add(new Item ("Mango", 2.0));
        fruitList.add(new Item ("Goji Berries", 4.0));
        fruitList.add(new Item ("Guava", 0.75));
		
		
		model.addAttribute("fruitList",fruitList);
		return "fruit.jsp";
	}
}
