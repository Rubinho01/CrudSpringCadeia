package com.seninha.CrudCadeia.entities;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class RegistrationPK {

	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "work_id", insertable = false, updatable = false)
    private Work work;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prisoner_id", insertable = false, updatable = false)
    private Prisoner prisoner;


    public RegistrationPK() {
    }

    public RegistrationPK(Work work, Prisoner prisoner) {
        this.work = work;
        this.prisoner = prisoner;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Prisoner getPrisoner() {
        return prisoner;
    }

    public void setPrisoner(Prisoner prisoner) {
        this.prisoner = prisoner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prisoner, work);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        RegistrationPK other = (RegistrationPK) obj;
        return Objects.equals(prisoner, other.prisoner) && 
               Objects.equals(work, other.work); 
    }
}
