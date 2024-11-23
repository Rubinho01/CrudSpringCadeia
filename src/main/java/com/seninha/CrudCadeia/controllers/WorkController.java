package com.seninha.CrudCadeia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.seninha.CrudCadeia.entities.Work;
import com.seninha.CrudCadeia.services.WorkService;

@Controller
public class WorkController {
	
	@Autowired
	private WorkService workServices;
	
	  @GetMapping("/works")
	    public String showWorks(Model model) {
	        List<Work> works = workServices.findAll();
	        model.addAttribute("works", works); 
	        return "all-works"; 
	    }
	
}
