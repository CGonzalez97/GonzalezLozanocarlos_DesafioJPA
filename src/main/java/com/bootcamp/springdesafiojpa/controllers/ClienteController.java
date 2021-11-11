package com.bootcamp.springdesafiojpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.springdesafiojpa.models.Cliente;
import com.bootcamp.springdesafiojpa.services.ClienteServiceI;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteServiceI clienteServicio;
	
	@GetMapping()
	public String getClientes(Model model) {	
		model.addAttribute("listado",clienteServicio.getClientes());
		return "listado_clientes";
	}
	
	@GetMapping("/add")
	public String addClientes(Model model) {
		model.addAttribute("newCliente",new Cliente());
		return "addCliente";
	}
	
	@PostMapping("/add")
	public String addCliente(@ModelAttribute("newCliente") Cliente clienteNuevo) {
		clienteServicio.addCliente(clienteNuevo);
		return "redirect:/clientes";
	}
	
	@PostMapping("/{id}")
	public String deleteCliente(@PathVariable("id") Long id) {
		clienteServicio.deleteClienteById(id);
		return "redirect:/clientes";
	}
	
	@PostMapping("/search")
	public String getClienteByName(@RequestParam(value="nombre") String nombre, Model model) {
		System.out.println("\n\nNombre: "+nombre+"\n\n");
		List<Cliente> clientesBuscados = clienteServicio.findByName(nombre);
		System.out.println("\n\nClientes buscados: "+clientesBuscados+"\n\n");
		model.addAttribute("clientes",clientesBuscados);
		return "listado_clientes_buscados";
	}

}
