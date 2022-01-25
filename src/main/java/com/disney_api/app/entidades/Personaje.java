package com.disney_api.app.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Personaje implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Integer edad;
	private Double peso;
	private String historia;
	
	@OneToOne
	private Imagen imagen;
	
	@ManyToMany(mappedBy = "personajes")
    private List<Pelicula> aparicion;
	
	public Personaje() {
	}

	public Personaje(Long id, String nombre, Integer edad, Double peso, String historia, Imagen imagen,
			List<Pelicula> aparicion) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
		this.imagen = imagen;
		this.aparicion = aparicion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}

	public List<Pelicula> getAparicion() {
		return aparicion;
	}

	public void setAparicion(List<Pelicula> aparicion) {
		this.aparicion = aparicion;
	}

	
	
	
}
