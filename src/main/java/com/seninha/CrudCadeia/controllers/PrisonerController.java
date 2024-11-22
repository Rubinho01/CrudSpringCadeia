package com.seninha.CrudCadeia.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seninha.CrudCadeia.entities.Prisoner;
import com.seninha.CrudCadeia.services.PrisonerService;

@Controller
@RequestMapping("/prisoners")
public class PrisonerController {
	
	@Autowired
	private PrisonerService prisonerService;
	
	@GetMapping
	public String findAll(Model model) {
		List<Prisoner> prisoner = prisonerService.findAll();
		model.addAttribute("prisoner", prisoner);
		return "prisoner/list";
	}
	@GetMapping("/new")
	public String saveForm(Model model) {
		model.addAttribute("prisoner", new Prisoner());
		return "/prisoner/create";
		
	}
	@PostMapping
	public String savePrisoner(@ModelAttribute Prisoner prisoner) {
		prisonerService.savePrisoner(prisoner);
		return "redirect:/prisoners";
	}
	@GetMapping("/delete/{id}")
	public String deletePrisoner(@PathVariable Long id) {
		prisonerService.DeleteById(id);
		return "redirect:/prisoners";
	}
	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable Long id,Model model) {
		Optional<Prisoner> prisoner =  prisonerService.findById(id);
		model.addAttribute("prisoner", prisoner.get());
		return "/prisoner/edit";
	}
	@PostMapping("/edit/{id}")
	public String editPrisoner(@PathVariable Long id,@ModelAttribute Prisoner updatedPrisoner) {
		updatedPrisoner.setId(id);
		prisonerService.savePrisoner(updatedPrisoner);
		return "redirect:/prisoners";
		
		
	}
}
