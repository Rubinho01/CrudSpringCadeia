package com.seninha.CrudCadeia.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Registrations")
public class Registration {
	
	@EmbeddedId
	private RegistrationPK id = new RegistrationPK();
	private String registrationDate;
	
	
	public Registration(Work work,Prisoner prisoner, String registrationDate) {
		super();
		id.setWork(work);
		id.setPrisoner(prisoner);
		this.registrationDate = registrationDate;
	}


	public RegistrationPK getId() {
		return id;
	}

	
	public void setId(RegistrationPK id) {
		this.id = id;
	}


	public String getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registration other = (Registration) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
