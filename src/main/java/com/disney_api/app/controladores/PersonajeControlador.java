package com.disney_api.app.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.disney_api.app.entidades.Personaje;
import com.disney_api.app.servicios.PersonajeServicio;


@RestController
@RequestMapping("/characters")
public class PersonajeControlador {

	@Autowired
	PersonajeServicio personajeServicio;
	
	@GetMapping()
	@ResponseBody
	public List<Personaje> listadoPersonaje(@RequestParam(required = false) String name, @RequestParam(required = false) String aparicion, @RequestParam(required = false) String peso, @RequestParam(required = false) String edad) throws Exception{
		
		if (name != null) {
			return  personajeServicio.personajeNombre(name);
		}else if (aparicion != null) {
            return personajeServicio.personajeAparicion(aparicion);
		}else if (edad != null) {
            return personajeServicio.personajeAparicion(edad);
		}else if (peso != null) {
            return personajeServicio.personajeAparicion(peso);
		}else {
			return personajeServicio.listadoPersonajes();
		}
		
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Personaje detallesPersonajes(@PathVariable Long id) throws Exception{
		return personajeServicio.detallePersonaje(id);
	}
	
	@PostMapping("/crear")
	public Personaje crearPersonaje(@RequestBody Personaje personaje) throws Exception {
		
		return  personajeServicio.crearPersonaje(personaje);
	}
	
	@PutMapping("/modificar")
	public Personaje modificarPersonaje(@RequestBody Personaje personaje) throws Exception {
		return personajeServicio.modificar(personaje);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminarPersonaje(@PathVariable Long id)throws Exception {
		personajeServicio.eliminar(id);
	}
	
	
	
}
