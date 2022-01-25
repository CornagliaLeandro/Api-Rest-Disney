package com.disney_api.app.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Genero implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Imagen imagen;
	
	@OneToMany
	private List<Pelicula> peliculasAsociadas;

	public Genero(Long id, Imagen imagen, List<Pelicula> peliculasAsociadas) {
		this.id = id;
		this.imagen = imagen;
		this.peliculasAsociadas = peliculasAsociadas;
	}

	public Genero() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}

	public List<Pelicula> getPeliculasAsociadas() {
		return peliculasAsociadas;
	}

	public void setPeliculasAsociadas(List<Pelicula> peliculasAsociadas) {
		this.peliculasAsociadas = peliculasAsociadas;
	}

	
	
	
	
}
