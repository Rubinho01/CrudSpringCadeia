package com.seninha.CrudCadeia.entities;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "works")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workId;

    private String workName;
    private Integer timeReduction;

    public Work() {
    }

    public Work(Long workId, String workName, Integer timeReduction) {
        this.workId = workId;
        this.workName = workName;
        this.timeReduction = timeReduction;
    }

    public Long getWorkId() {
        return workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public Integer getTimeReduction() {
        return timeReduction;
    }

    public void setTimeReduction(Integer timeReduction) {
        this.timeReduction = timeReduction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(workId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Work other = (Work) obj;
        return Objects.equals(workId, other.workId);
    }
}
