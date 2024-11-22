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

    // Listar todas as células
    @GetMapping
    public String getAllCells(Model model) {
        List<Cell> cells = cellService.getAllCells();
        model.addAttribute("cells", cells);
        return "cell/list";  // Retorna para a view 'list.html'
    }

    // Criar uma nova célula (abrir o formulário)
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("cell", new Cell());
        return "cell/create";  // Retorna para o formulário 'create.html'
    }

    // Criar uma nova célula (salvar)
    @PostMapping
    public String createCell(@ModelAttribute Cell cell) {
        cellService.saveCell(cell);
        return "redirect:/cells";  // Redireciona para a lista de células
    }

    // Editar célula existente (abrir o formulário)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Cell> cell = cellService.getCellById(id);
        if (cell.isPresent()) {
            model.addAttribute("cell", cell.get());
            return "cell/edit";  // Retorna para o formulário de edição 'edit.html'
        }
        return "redirect:/cells";  // Redireciona para a lista se não encontrar a célula
    }

    // Atualizar célula
    @PostMapping("/edit/{id}")
    public String updateCell(@PathVariable Long id, @ModelAttribute Cell updatedCell) {
        updatedCell.setCellId(id);
        cellService.saveCell(updatedCell);
        return "redirect:/cells";  // Redireciona para a lista de células
    }

    // Excluir célula
    @GetMapping("/delete/{id}")
    public String deleteCell(@PathVariable Long id) {
        cellService.deleteCell(id);
        return "redirect:/cells";  // Redireciona para a lista de células
    }
}
