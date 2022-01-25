package com.disney_api.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disney_api.app.entidades.Personaje;

@Repository
public interface PersonajeRepositorio extends JpaRepository<Personaje, Long> {

}
