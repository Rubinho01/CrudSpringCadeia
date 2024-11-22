package com.seninha.CrudCadeia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seninha.CrudCadeia.entities.Prisoner;
import com.seninha.CrudCadeia.reposiories.PrisonerRepository;

@Service
public class PrisonerService {
	@Autowired
	PrisonerRepository prisonerRepository;
	
	public List<Prisoner> findAll(){
		return prisonerRepository.findAll();
	}
	
	public Optional<Prisoner> findById(Long id){
		return prisonerRepository.findById(id);
	}
	public void DeleteById(Long id) {
		prisonerRepository.deleteById(id);
	}
	public Prisoner savePrisoner(Prisoner prisoner) {
		return prisonerRepository.save(prisoner);
	}

}
