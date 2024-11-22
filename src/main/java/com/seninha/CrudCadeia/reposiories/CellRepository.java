package com.seninha.CrudCadeia.reposiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seninha.CrudCadeia.entities.Cell;

@Repository
public interface CellRepository extends JpaRepository<Cell, Long> {

}
