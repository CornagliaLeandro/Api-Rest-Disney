package com.disney_api.app.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.disney_api.app.entidades.Personaje;

@Repository
public interface PersonajeRepositorio extends JpaRepository<Personaje, Long> {
	
	@Query("SELECT p FROM Personaje p WHERE p.nombre =:name")
	public List<Personaje> personajeNombre(@Param ("name") String name);

    @Query("SELECT p FROM Personaje p WHERE p.aparicion = :aparicion")
    public List<Personaje> personajeAparicion(@Param("aparicion") String aparicion);
    
    @Query("SELECT p FROM Personaje p WHERE edad = :age")
    public List<Personaje> personajeEdad(@Param("age") Integer edad);

    @Query("SELECT p FROM Personaje p WHERE peso = :weight")
    public List<Personaje> personajePeso(@Param("weight") Double peso);

}
