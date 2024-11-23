package com.seninha.CrudCadeia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seninha.CrudCadeia.entities.Cell;
import com.seninha.CrudCadeia.reposiories.CellRepository;

@Service
public class CellService {

    @Autowired
    private CellRepository cellRepository;

    public List<Cell> findAll() {
        return cellRepository.findAll();
    }

    public Optional<Cell> getCellById(Long id) {
        return cellRepository.findById(id);
    }

    public Cell saveCell(Cell cell) {
        return cellRepository.save(cell);
    }

    public void deleteCell(Long id) {
        cellRepository.deleteById(id);
    }
}
