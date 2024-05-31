package com.clubjhon.demo.controlador;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.clubjhon.demo.variables.*;
import com.clubjhon.demo.servicios.*;
@Controller
public class ClubController {

	@Autowired
	private ServiciosCrudClub servicioscrudclub;

	@Autowired
	private ServiciosCrudEntrenador servicioscrudentrenador;
	
	@Autowired
	private ServiciosCrudAsociacion servicioscrudasociacion;
	
	@Autowired
	private ServiciosCrudCompeticion servicioscrudcompeticion;
	
	@GetMapping("/verClub")
	public String listarClub(Model model) {
		List<Club> listaClub = servicioscrudclub.findAll();
		model.addAttribute("listaClub",listaClub);
		
		return "verClub";
	}
	
	@GetMapping("/Verclub/formClub")
	public String mostrarFormulario (Model model) {
		model.addAttribute("club",new Club());
		
		List<Entrenador>
		listaEntrenador = servicioscrudentrenador.findAll();
		
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		List<Asociacion>
		ListaASociacion = servicioscrudasociacion.findAll();
		model.addAttribute("ListaASociacion", ListaASociacion);
		
		List<Competicion>
		listaCompeticion = servicioscrudcompeticion.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);
		
		return "formClub";
	}

	@PostMapping("/guardarClub")
	public String guardarClub (Club club) {
		servicioscrudclub.save(club);
		return "redirect:/verClub";
	}
	
	@GetMapping ("/club/editar/{id}")
	public String modificarClub (@PathVariable("id") Integer id, Model model) {
		Club club = servicioscrudclub.findById(id).get();
		model.addAttribute("club",club);
		List<Entrenador>
		listaEntrenador = servicioscrudentrenador.findAll();
		
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		List<Asociacion>
		listAsociacion = servicioscrudasociacion.findAll();
		
		model.addAttribute("listAsociacion", listAsociacion);
		
		List <Competicion>
		listaCompeticion = servicioscrudcompeticion.findAll();
		
		model.addAttribute("listaCompeticion", listaCompeticion);
		
		return "formClub";
	}
	
	@GetMapping ("/club/eliminar/{id}")
	public String eliminarClub(@PathVariable("id") Integer id, Model model) {
		servicioscrudclub.deleteById(id);
		return "redirect:/verClub";
	}
}
