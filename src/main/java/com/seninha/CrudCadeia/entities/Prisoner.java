package com.seninha.CrudCadeia.entities;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prisoners")
public class Prisoner {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;
    private String firstName;
    private String lastName;
    private Integer sentenceDuration;

    @ManyToOne
    @JoinColumn(name = "cell_id", nullable = false)
    private Cell cell;

    public Prisoner() {
    }

    public Prisoner(Cell cell, Long id, String cpf, String firstName, String lastName, Integer sentenceDuration) {
        this.cell = cell;
        this.id = id;
        this.cpf = cpf;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sentenceDuration = sentenceDuration;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSentenceDuration() {
        return sentenceDuration;
    }

    public void setSentenceDuration(Integer sentenceDuration) {
        this.sentenceDuration = sentenceDuration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Prisoner other = (Prisoner) obj;
        return Objects.equals(id, other.id);
    }
}
