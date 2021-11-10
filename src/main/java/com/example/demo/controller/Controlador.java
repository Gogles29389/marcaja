package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfacesService.ImarcajeService;
import com.example.demo.modelo.Marcaje;
import net.sf.jasperreports.engine.JRException;

@Controller
@RequestMapping
public class Controlador {

	@Autowired
	private ImarcajeService service;
	
	
	@GetMapping("/listar")
	public String listar(Model model){
		List<Marcaje>marcajes=service.listar();
		model.addAttribute("marcajes",marcajes);
		return "index";
		
	}
	
	@GetMapping("/nuevo")
	public String agregar(Model model) {
		model.addAttribute("marcajes",new Marcaje());
		return "Form";
	}
	
	@PostMapping("/guardar") 
	public String save(@Validated Marcaje m, Model model) {
		service.save(m);
		return "redirect:/listar";
		
	}
	
	@GetMapping("/editar/{id_marcaje}")
	public String editar(@PathVariable int id_marcaje, Model model) {
		Optional<Marcaje>marcaje=service.listarId(id_marcaje);
		model.addAttribute("marcajes", marcaje);
		return "Form";
	}
	
	@GetMapping("/eliminar/{id_marcaje}")
	public String delete(Model model, @PathVariable int id_marcaje) {
		service.delete(id_marcaje);
		return "redirect:/listar";
	}
	
	@GetMapping("/export/{format}")
	private String exportReport(@PathVariable String format) throws FileNotFoundException, JRException {
		
		return service.exportReport(format);
		
	}
	
	
}
