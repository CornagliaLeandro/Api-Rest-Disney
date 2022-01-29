package com.disney_api.app.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.disney_api.app.entidades.Usuario;
import com.disney_api.app.enumeraciones.Rol;
import com.disney_api.app.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio  implements UserDetailsService{
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	public void crearUsuario(Usuario usuario) throws Exception {
		
		
		try {
			String claveEncriptada = new BCryptPasswordEncoder().encode(usuario.getContrasena());
			usuario.setContrasena(claveEncriptada);
			usuario.setRol(Rol.USER);
			usuarioRepositorio.save(usuario);
		} catch (Exception e) {
			throw new Exception("Error al crear usuario");
		}
		
		
	}
	
	public UserDetails loadUserByUsername(String nombreDeUsuario) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.buscarPorUsername(nombreDeUsuario);
		User user = null;
		if (usuario != null ) {
			List<GrantedAuthority> permisos = new ArrayList<>();
			GrantedAuthority permiso = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());
			permisos.add(permiso);
			
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			
			HttpSession session = attr.getRequest().getSession(true);
			session.setAttribute("usuariosession", usuario);
			user = new User(nombreDeUsuario, usuario.getContrasena(), permisos);
		} else {
			throw new UsernameNotFoundException("El usuario no se encontró");
		}
		return user;
	}

}
