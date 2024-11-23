package com.seninha.CrudCadeia.controllers;

import com.seninha.CrudCadeia.entities.Cell;
import com.seninha.CrudCadeia.services.CellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cells")
public class CellController {

    @Autowired
    private CellService cellService;

    @GetMapping
    public String getAllCells(Model model) {
        List<Cell> cells = cellService.findAll();
        model.addAttribute("cells", cells);
        return "cell/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("cell", new Cell());
        return "cell/create";
    }

    @PostMapping
    public String createCell(@ModelAttribute Cell cell) {
        cellService.saveCell(cell);
        return "redirect:/cells"; 
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Cell> cell = cellService.getCellById(id);
        if (cell.isPresent()) {
            model.addAttribute("cell", cell.get());
            return "cell/edit";
        }
        return "redirect:/cells";
    }

    @PostMapping("/edit/{id}")
    public String updateCell(@PathVariable Long id, @ModelAttribute Cell updatedCell) {
        updatedCell.setCellId(id);
        cellService.saveCell(updatedCell);
        return "redirect:/cells";
    }

    @GetMapping("/delete/{id}")
    public String deleteCell(@PathVariable Long id) {
        cellService.deleteCell(id);
        return "redirect:/cells";
    }
}
