package com.seninha.CrudCadeia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seninha.CrudCadeia.entities.Cell;
import com.seninha.CrudCadeia.reposiories.CellRepository;

@Service
public class CellServices {
	@Autowired
	private CellRepository cellRepository;
	
	public List<Cell> seeAll(){
		var result = cellRepository.findAll();
		var cells = result.stream().map(x -> new Cell()).toList();
		return cells;
	}
	
	
	
}
