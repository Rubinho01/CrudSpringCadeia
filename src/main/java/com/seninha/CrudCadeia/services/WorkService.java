package com.seninha.CrudCadeia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seninha.CrudCadeia.entities.Work;
import com.seninha.CrudCadeia.reposiories.WorkRepository;

@Service
public class WorkService {
	@Autowired
	private WorkRepository workRepository;
	
	
	public List<Work> findAll() {
	    return workRepository.findAll();
	    }
	public Optional<Work> findById(Long id){
		return workRepository.findById(id);
	}
}