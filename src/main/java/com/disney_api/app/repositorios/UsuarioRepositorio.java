package com.disney_api.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.disney_api.app.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

	@Query("SELECT u FROM Usuario u where usuario = :usuario")
    public Usuario buscarPorUsername(@Param("usuario") String usuario);
}
