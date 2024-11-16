package com.seninha.CrudCadeia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seninha.CrudCadeia.entities.Cell;
import com.seninha.CrudCadeia.entities.Work;
import com.seninha.CrudCadeia.reposiories.WorkRepository;

@Service
public class WorkServices {
	@Autowired
	private WorkRepository workRepository;
	
	public List<Work> findAll(){
		var result = workRepository.findAll();
		var works = result.stream().map(x -> new Work()).toList();
		return works;
	}
	
	public void seeAll(){
		workRepository.findAll().forEach(x -> System.out.println(x.getWorkName()+ ""+x.getTimeReduction()));
	}
	
	
}
