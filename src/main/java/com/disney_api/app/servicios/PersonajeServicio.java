package com.disney_api.app.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney_api.app.entidades.Personaje;
import com.disney_api.app.repositorios.PersonajeRepositorio;

@Service
public class PersonajeServicio {

	@Autowired
	PersonajeRepositorio personajeRepositorio;

	public Personaje crearPersonaje(Personaje personaje) {
		return personajeRepositorio.save(personaje);
	}
	
}
