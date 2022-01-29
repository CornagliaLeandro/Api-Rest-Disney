package com.disney_api.app.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.disney_api.app.entidades.Pelicula;
import com.disney_api.app.servicios.PeliculaServicio;

@RestController
@RequestMapping("/movies")
public class PeliculaControlador {

	@Autowired
	PeliculaServicio peliculaServicio;

	@GetMapping
	@ResponseBody
	public List<Pelicula> listaPelicula(@RequestParam(required = false) String name,
			@RequestParam(required = false) String order) throws Exception {

	
		if (name != null) {
			return peliculaServicio.peliculaPorNombre(name);
		} else if (order != null && order.equalsIgnoreCase("asc")) {
			return peliculaServicio.peliculaFechaAsc(order);
		}else if (order != null && order.equalsIgnoreCase("desc")) {
			return peliculaServicio.peliculaFechaDesc(order);
		}else {
			return peliculaServicio.listaPeliculas();
		}
	
	}

	@PostMapping("/crear")
	public void PeliculaDetalle(@RequestBody Pelicula pelicula) throws Exception {
		peliculaServicio.crearPelicula(pelicula);
	}

	@PutMapping("/modificar")
	public void modificarPelicula(@RequestBody Pelicula pelicula) throws Exception {
		peliculaServicio.modificarPelicula(pelicula);
	}

	@DeleteMapping("/eliminar")
	public void borrarPelicula(Pelicula pelicula) throws Exception {
		peliculaServicio.eliminarPelicula(pelicula);
	}

	@GetMapping("detalle")
	@ResponseBody
	public List<Pelicula> detallesPelicula() throws Exception {
		return peliculaServicio.detallePelicula();
	}

}
