package com.disney_api.app.servicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney_api.app.entidades.Personaje;
import com.disney_api.app.repositorios.PersonajeRepositorio;

@Service
public class PersonajeServicio {

	@Autowired
	PersonajeRepositorio personajeRepositorio;
	
	public List<Personaje> listadoPersonajes(){
		List<Personaje> listaCompleta = personajeRepositorio.findAll();
		List<Personaje> listaMostrar = new ArrayList<Personaje>();
		
		for (Personaje personaje : listaCompleta) {
			Personaje p = new Personaje();
			p.setImagen(personaje.getImagen());
			p.setNombre(personaje.getNombre());
			listaMostrar.add(p);
			
		}
		
		return listaMostrar;
	}

	public Personaje detallePersonaje(Long id) throws Exception {
		
		try {
			return personajeRepositorio.findById(id).get();
		} catch (Exception e) {
			throw new Exception("Error al detallar personaje");
		}
		
	}

	public Personaje crearPersonaje(Personaje personaje) throws Exception {

		try {
			return personajeRepositorio.save(personaje);
		} catch (Exception e) {
			throw new Exception("Error al crear el personaje");
		}

	}

	public Personaje modificar(Personaje personaje) throws Exception {

		try {
			if (personajeRepositorio.findById(personaje.getId()).isPresent()) {
				return personajeRepositorio.save(personaje);
			
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new Exception("Error al modificar Personaje");
		
		}
	
	}
	
	public void eliminar(Long id) throws Exception {
		try {
			personajeRepositorio.deleteById(id);
		} catch (Exception e) {
			throw new Exception ("Error al eliminar un Personaje");
		}
		
	}
	
	public List<Personaje> personajeNombre(String nombre) throws Exception{
		try {
			return personajeRepositorio.personajeNombre(nombre);
		} catch (Exception e) {
			throw new Exception("Error al buscar por nombre");
		}
		
	}
	
	public List<Personaje> personajeAparicion(String aparicion) throws Exception{
		try {
			return personajeRepositorio.personajeAparicion(aparicion);
		} catch (Exception e) {
			throw new Exception("Error al buscar por Pelicula");
		}
        
    } 
	
	public List<Personaje> personajeEdad(Integer edad) throws Exception{
		try {
			return personajeRepositorio.personajeEdad(edad);
		} catch (Exception e) {
			throw new Exception("Error al buscar por Edad");
		}
		
        
    } 
	
	public List<Personaje> personajePeso(Double peso) throws Exception{
		try {
			return personajeRepositorio.personajePeso(peso);
		} catch (Exception e) {
			throw new Exception("Error al buscar por Peso");
		}
        
    } 


}
