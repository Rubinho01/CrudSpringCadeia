package com.seninha.CrudCadeia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seninha.CrudCadeia.entities.Prisoner;
import com.seninha.CrudCadeia.entities.Registration;
import com.seninha.CrudCadeia.entities.Work;
import com.seninha.CrudCadeia.reposiories.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	public void saveRegistartion(Work work,Prisoner prisoner, String registrationDate) {
		Registration registration = new Registration(work,prisoner,registrationDate);
		
		registration.reduceSentence();
		registrationRepository.save(registration);
	}
	public List<Registration> findAll(){
		return registrationRepository.findAll();
	}
}
