package com.disney_api.app.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disney_api.app.entidades.Personaje;
import com.disney_api.app.servicios.PersonajeServicio;


@RestController
@RequestMapping("/character")
public class PersonajeControlador {

	@Autowired
	PersonajeServicio personajeServicio;
	
	@PostMapping("/crear")
	public Personaje crearPersonaje(@RequestBody Personaje personaje) {
		
		return  personajeServicio.crearPersonaje(personaje);
	}
	
	
}
