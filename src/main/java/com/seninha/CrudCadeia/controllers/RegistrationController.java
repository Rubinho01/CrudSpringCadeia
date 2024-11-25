package com.seninha.CrudCadeia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.seninha.CrudCadeia.entities.Prisoner;
import com.seninha.CrudCadeia.entities.Registration;
import com.seninha.CrudCadeia.entities.Work;
import com.seninha.CrudCadeia.services.PrisonerService;
import com.seninha.CrudCadeia.services.RegistrationService;
import com.seninha.CrudCadeia.services.WorkService;

@Controller
@RequestMapping("/registrations")
public class RegistrationController {
    @Autowired
    private WorkService workService;

    @Autowired
    private PrisonerService prisonerService;

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public String findAll(Model model) {
    	List<Registration> registrations =   registrationService.findAll();
    	model.addAttribute("registrations", registrations);
    	return "/registration/list";
    }
    
    @GetMapping("/new")
    public String saveForm(Model model) {
        List<Work> works = workService.findAll();
        List<Prisoner> prisoners = prisonerService.findAll();

        model.addAttribute("works", works);
        model.addAttribute("prisoners", prisoners);

        System.out.println("Works encontrados: " + works.size());
        System.out.println("Prisoners encontrados: " + prisoners.size());

        return "/registration/create";
    }

    @PostMapping
    public String saveRegistration(
            @RequestParam Long workId,
            @RequestParam Long prisonerId,
            @RequestParam String registrationDate,
            RedirectAttributes redirectAttributes) {
        try {
            Work work = workService.findById(workId)
                    .orElseThrow(() -> new RuntimeException("Trabalho não encontrado com ID: " + workId));
            Prisoner prisoner = prisonerService.findById(prisonerId)
                    .orElseThrow(() -> new RuntimeException("Prisioneiro não encontrado com ID: " + prisonerId));

            registrationService.saveRegistartion(work, prisoner, registrationDate);

            redirectAttributes.addFlashAttribute("message", "Registro criado com sucesso!");
            return "redirect:/registrations";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/registrations/new";
        }
    }
    
}
