package com.seninha.CrudCadeia.reposiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seninha.CrudCadeia.entities.Work;

@Repository
public interface WorksRepository extends JpaRepository<Work, Long> {

}
