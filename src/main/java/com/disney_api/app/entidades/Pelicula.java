package com.disney_api.app.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pelicula implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPelicula;
	private String titulo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String fechaCreacion;
	private Integer calificacion;
	
	
	@OneToOne
	private Imagen imagen;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Personaje> personajes;

	public Pelicula(Long idPelicula, String titulo, String fechaCreacion, Integer calificacion, Imagen imagen,
			List<Personaje> personajes) {
		this.idPelicula = idPelicula;
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.calificacion = calificacion;
		this.imagen = imagen;
		this.personajes = personajes;
	}

	public Pelicula() {
	}

	public Long getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(Long idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}
	
	
	
}
