package com.seninha.CrudCadeia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String showMainPage() {
        return "index"; // Nome do arquivo HTML (sem a extensão .html)
    }
}
