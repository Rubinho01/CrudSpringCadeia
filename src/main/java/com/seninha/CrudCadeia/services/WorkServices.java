package com.seninha.CrudCadeia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seninha.CrudCadeia.DTO.WorkDTO;
import com.seninha.CrudCadeia.entities.Work;
import com.seninha.CrudCadeia.reposiories.WorkRepository;

@Service
public class WorkServices {
	@Autowired
	private WorkRepository workRepository;
	
	
	public List<Work> findAll() {
	    return workRepository.findAll();
	    
	
}
}