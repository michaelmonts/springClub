package com.clubjhon.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.clubjhon.demo.servicios.ServiciosCrudJugador;
import com.clubjhon.demo.variables.Jugador;

@Controller
public class JugadorController {

	@Autowired
	private ServiciosCrudJugador servicioscrudjugador;
	
	@GetMapping("/verJugador")
	public String listarJugador(Model model) {
		List<Jugador> listaJugador = servicioscrudjugador.findAll();
		model.addAttribute("listaJugador",listaJugador);
		
		return "verJugador";
	}
	
	@GetMapping("/VerJugador/formJugador")
	public String mostrarFormulario (Model model) {
		model.addAttribute("jugador",new Jugador());
		List<Jugador>
		listaJugador = servicioscrudjugador.findAll();
		model.addAttribute("listaJugador", listaJugador);
		return "formJugador";
		}
	
	@PostMapping("/guardarJugador")
	public String guardarJugador (Jugador jugador) {
		servicioscrudjugador.save(jugador);
		return "redirect:/verJugador";
	}
	@GetMapping ("/jugador/editar/{id}")
	public String modificarJugador (@PathVariable("id") Integer id, Model model) {
		Jugador jugador = servicioscrudjugador.findById(id).get();
		model.addAttribute("jugador",jugador);
		List<Jugador>
		listaJugador = servicioscrudjugador.findAll();
		
		model.addAttribute("listaJugador", listaJugador);
		
		return "formJugador";
	}
}
