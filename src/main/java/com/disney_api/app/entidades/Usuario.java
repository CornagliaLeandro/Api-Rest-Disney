package com.disney_api.app.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.disney_api.app.enumeraciones.Rol;

@Entity
public class Usuario implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String usuario;
    private String contrasena;
    private String email;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    
    
    public Usuario() {
    }

    

    public Usuario(Long id, String usuario, String contrasena, String email, Rol rol) {
		this.id = id;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.email = email;
		this.rol = rol;
	}



	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public Rol getRol() {
		return rol;
	}



	public void setRol(Rol rol) {
		this.rol = rol;
	}
    
	
    

}
