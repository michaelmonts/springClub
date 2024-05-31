package com.clubjhon.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.clubjhon.demo.servicios.ServiciosCrudCompeticion;
import com.clubjhon.demo.variables.Competicion;

@Controller
public class CompeticionController {
	@Autowired
	private ServiciosCrudCompeticion servicioscrudcompeticion;
	
   	@GetMapping("/verCompeticion")
	public String listarCompeticion(Model model) {
		List<Competicion> listaCompeticion = servicioscrudcompeticion.findAll();
		model.addAttribute("listaCompeticion",listaCompeticion);
		
		return "verCompeticion";
	}
	@GetMapping("/verCompeticion/formCompeticion")
	public String mostrarFormulario (Model model) {
		model.addAttribute("competicion",new Competicion());
		List<Competicion>
		listaCompeticion = servicioscrudcompeticion.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);
		return "formCompeticion";
		}
	
	@PostMapping("/guardarCompeticion")
	public String guardarCompeticion (Competicion competicion) {
		servicioscrudcompeticion.save(competicion);
		return "redirect:/verCompeticion";
	}
	
	@GetMapping ("/competicion/editar/{id}")
	public String modificarCompeticion (@PathVariable("id") Integer id, Model model) {
		Competicion competicion = servicioscrudcompeticion.findById(id).get();
		model.addAttribute("competicion",competicion);
		
		List <Competicion>
		listaCompeticion = servicioscrudcompeticion.findAll();
		
		model.addAttribute("listaCompeticion", listaCompeticion);
		
		return "formCompeticion";
	}
	@GetMapping ("/competicion/eliminar/{id}")
	public String eliminarCompeticion(@PathVariable("id") Integer id, Model model) {
		servicioscrudcompeticion.deleteById(id);
		return "redirect:/verCompeticion";
	}
}
