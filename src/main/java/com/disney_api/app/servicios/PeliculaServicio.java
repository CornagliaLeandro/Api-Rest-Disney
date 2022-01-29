package com.disney_api.app.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.disney_api.app.entidades.Pelicula;
import com.disney_api.app.repositorios.PeliculaRepositorio;

@Service
public class PeliculaServicio {
	
	@Autowired
	PeliculaRepositorio peliculaRepositorio;
	
	public List<Pelicula> listaPeliculas(){
		List<Pelicula> lista = new ArrayList<>();
		List<Pelicula> peliculas = peliculaRepositorio.findAll();
		for (Pelicula peli : peliculas) {
			Pelicula p = new Pelicula();
			p.setImagen(peli.getImagen());
			p.setTitulo(peli.getTitulo());
			p.setFechaCreacion(peli.getFechaCreacion());
			lista.add(p);
		}
		
		return lista;
	}
	
	@Transactional
	public void crearPelicula(Pelicula pelicula) throws Exception {
		try {
			calificacion(pelicula);
			peliculaRepositorio.save(pelicula);
		} catch (Exception e) {
	throw new Exception ("Error al crear pelicula");
			
		}
	}
	
	public void modificarPelicula(Pelicula pelicula) throws Exception{
		
		try {
			if(peliculaRepositorio.findById(pelicula.getIdPelicula()).isPresent()) {
				calificacion(pelicula);
				peliculaRepositorio.save(pelicula);
			}
		} catch (Exception e) {
			throw new Exception("Error al modificar pelicula");
		}
		
	}
	
	@Transactional
	public void eliminarPelicula(Pelicula pelicula) throws Exception{
		try {
			peliculaRepositorio.delete(pelicula);
		} catch (Exception e) {
			throw new Exception("Error al eliminar pelicula");
		}
	}
	
	
	
	public List<Pelicula> detallePelicula() throws Exception{
		
		try {
			return peliculaRepositorio.findAll();
		} catch (Exception e) {
			throw new Exception ("Error al buscar detalles de peliculas");
		}
		
		
		
	}
	
	public List<Pelicula> peliculaPorNombre(String nombre)throws Exception{
		try {
			return peliculaRepositorio.peliculaNombre(nombre);
		} catch (Exception e) {
			throw new Exception("Error al buscar pelicula por nombre");
		}
		
	}
	
	public List<Pelicula> peliculaFechaDesc(String fecha)throws Exception{
		try {
			return peliculaRepositorio.peliculaFechaDesc(fecha);
			} catch (Exception e) {
				throw new Exception("Error al ordenar peliculas por fecha descendente ");
			}
		
	}
	public List<Pelicula> peliculaFechaAsc(String fecha)throws Exception{
		try {
			return peliculaRepositorio.peliculaFechaAsc(fecha);
			} catch (Exception e) {
				throw new Exception("Error al ordenar peliculas por fecha ascendente ");
			}
	}
	
	public Pelicula calificacion(Pelicula pelicula) {
		
		if(pelicula.getCalificacion() > 5) {
			pelicula.setCalificacion(5);
		}else if(pelicula.getCalificacion()< 1) {
			pelicula.setCalificacion(1);
		}
		
		return pelicula;
	}

}
