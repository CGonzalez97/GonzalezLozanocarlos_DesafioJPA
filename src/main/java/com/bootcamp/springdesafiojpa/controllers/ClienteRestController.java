package com.bootcamp.springdesafiojpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.springdesafiojpa.models.Cliente;
import com.bootcamp.springdesafiojpa.services.ClienteServiceI;

@RestController
@RequestMapping("/rest/cliente")
public class ClienteRestController {
	
	@Autowired
	ClienteServiceI clienteServicio;
	
	@GetMapping()
	public List<Cliente> getClientes() {	
		return clienteServicio.getClientes();
	}
	
	@PostMapping("/add")
	public void addCliente(@RequestBody Cliente clienteNuevo) {
		clienteServicio.addCliente(clienteNuevo);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable("id") Long id) {
		clienteServicio.deleteClienteById(id);
	}
	
	@GetMapping("/search/{nombre}")
	public List<Cliente> getClienteByName(@PathVariable String nombre) {
		return clienteServicio.findByName(nombre);
	}

}
