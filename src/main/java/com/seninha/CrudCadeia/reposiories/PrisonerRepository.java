package com.seninha.CrudCadeia.reposiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seninha.CrudCadeia.entities.Prisoner;

@Repository
public interface PrisonerRepository extends JpaRepository<Prisoner, Long> {

}
