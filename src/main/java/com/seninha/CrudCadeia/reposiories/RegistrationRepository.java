package com.seninha.CrudCadeia.reposiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seninha.CrudCadeia.entities.Registration;
import com.seninha.CrudCadeia.entities.RegistrationPK;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, RegistrationPK> {

}
