package com.seninha.CrudCadeia.entities;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cells")
public class Cell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cellId;

    private String cellName;
    private Integer maxPrisoners;

    public Cell() {
    }

    public Cell(Long cellId, String cellName, Integer maxPrisoners) {
        this.cellId = cellId;
        this.cellName = cellName;
        this.maxPrisoners = maxPrisoners;
    }

    public Long getCellId() {
        return cellId;
    }

    public void setCellId(Long cellId) {
        this.cellId = cellId;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public Integer getMaxPrisoners() {
        return maxPrisoners;
    }

    public void setMaxPrisoners(Integer maxPrisoners) {
        this.maxPrisoners = maxPrisoners;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cellId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Cell other = (Cell) obj;
        return Objects.equals(cellId, other.cellId);
    }
}
