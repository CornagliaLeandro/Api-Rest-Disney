package com.disney_api.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disney_api.app.entidades.Usuario;
import com.disney_api.app.servicios.UsuarioServicio;

@RestController
@RequestMapping("/auth")
public class UsuarioControlador {

	@Autowired
	UsuarioServicio usuarioServicio;
	
    @PostMapping("/register")
    public String saveUser(@RequestBody Usuario usuario) throws Exception {
        usuarioServicio.crearUsuario(usuario);
        return "Usuario registrado";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Usuario usuario) {
        try {
            if(usuario != null){
                usuarioServicio.loadUserByUsername(usuario.getUsuario());
              return "Usuario logueado";
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
          return "error al loguear usuario";
        }
    }
	
}
