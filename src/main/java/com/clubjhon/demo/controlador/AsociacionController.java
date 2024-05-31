package com.clubjhon.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.clubjhon.demo.servicios.ServiciosCrudAsociacion;
import com.clubjhon.demo.variables.Asociacion;
@Controller
public class AsociacionController {
	
	@Autowired
	private ServiciosCrudAsociacion servicioscrudasociacion;
	
	@GetMapping("/verAsociacion")
	public String listarAsociacion(Model model) {
		List<Asociacion> listaAsociacion = servicioscrudasociacion.findAll();
		model.addAttribute("listaAsociacion",listaAsociacion);
		
		return "verAsociacion";
	}
	
	@GetMapping("/VerAsociacion/formAsociacion")
	public String mostrarFormulario (Model model) {
		model.addAttribute("asociacion",new Asociacion());
		List<Asociacion>
		ListaASociacion = servicioscrudasociacion.findAll();
		model.addAttribute("ListaASociacion", ListaASociacion);
		return "formAsociacion";
		}
	
	@PostMapping("/guardarAsociacion")
	public String guardarAsociacion (Asociacion asociacion) {
		servicioscrudasociacion.save(asociacion);
		return "redirect:/verAsociacion";
	}
	
	@GetMapping ("/asociacion/editar/{id}")
	public String modificarAsociacion (@PathVariable("id") Integer id, Model model) {
		Asociacion asociacion = servicioscrudasociacion.findById(id).get();
		model.addAttribute("asociacion",asociacion);
		List<Asociacion>
		listAsociacion = servicioscrudasociacion.findAll();
		
		model.addAttribute("listAsociacion", listAsociacion);
		
		return "formClub";
	}
	@GetMapping ("/asociacion/eliminar/{id}")
	public String eliminarAsociacion(@PathVariable("id") Integer id, Model model) {
		servicioscrudasociacion.deleteById(id);
		return "redirect:/verAsociacion";
	}
}
