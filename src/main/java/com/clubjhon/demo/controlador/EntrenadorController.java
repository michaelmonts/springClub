package com.clubjhon.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.clubjhon.demo.servicios.ServiciosCrudEntrenador;
import com.clubjhon.demo.variables.Entrenador;
@Controller
public class EntrenadorController {
	@Autowired
	private ServiciosCrudEntrenador servicioscrudentrenador;
	@GetMapping("/verEntrenador")
	public String listarClub(Model model) {
		List<Entrenador> listaEntrenador = servicioscrudentrenador.findAll();
		model.addAttribute("listaEntrenador",listaEntrenador);
		
		return "verEntrenador";
	}
	@GetMapping("/verEntrenador/formEntrenador")
	public String mostrarFormulario (Model model) {
		model.addAttribute("entrenador",new Entrenador());
		
		List<Entrenador>
		listaEntrenador = servicioscrudentrenador.findAll();
		
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		return "formEntrenador";
	}
	@PostMapping("/guardarEntrenador")
	public String guardarEntrenador (Entrenador entrenador) {
		servicioscrudentrenador.save(entrenador);
		return "redirect:/verEntrenador";
	}
	
	@GetMapping ("/entrenador/editar/{id}")
	public String modificarEntrenador(@PathVariable("id") Integer id, Model model) {
		Entrenador entrenador = servicioscrudentrenador.findById(id).get();
		model.addAttribute("entrenador",entrenador);
		List<Entrenador>
		listaEntrenador = servicioscrudentrenador.findAll();
		
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		return "formEntrenador";
	}
	
	@GetMapping ("/entrenador/eliminar/{id}")
	public String eliminarClub(@PathVariable("id") Integer id, Model model) {
		servicioscrudentrenador.deleteById(id);
		return "redirect:/verEntrenador";
	}
}
