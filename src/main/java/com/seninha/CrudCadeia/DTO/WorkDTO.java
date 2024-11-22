package com.seninha.CrudCadeia.DTO;

import com.seninha.CrudCadeia.entities.Work;

public class WorkDTO {
	private Long id;
	private String name;
	private Integer timeReduction;
	
	
	public WorkDTO(Work entity) {
		this.id = entity.getWorkId();
		this.name = entity.getWorkName();
		this.timeReduction = entity.getTimeReduction();
		
		
		
	}


	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public Integer getTimeReduction() {
		return timeReduction;
	}

}
