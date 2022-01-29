package com.disney_api.app.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.disney_api.app.entidades.Pelicula;

@Repository
public interface PeliculaRepositorio extends JpaRepository<Pelicula, Long> {
	
	@Query("SELECT p FROM Pelicula p WHERE p.titulo=:name")
	public List<Pelicula> peliculaNombre(@Param("name") String name);
	
	@Query("SELECT p FROM Pelicula p ORDER BY  p.fechaCreacion DESC")
	public List<Pelicula> peliculaFechaDesc(String fecha);
	
	@Query("SELECT p FROM Pelicula p ORDER BY  p.fechaCreacion ASC")
	public List<Pelicula> peliculaFechaAsc(String fecha);
	

}
