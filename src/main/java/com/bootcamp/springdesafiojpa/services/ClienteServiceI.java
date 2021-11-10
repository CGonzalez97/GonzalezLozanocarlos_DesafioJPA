package com.bootcamp.springdesafiojpa.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.bootcamp.springdesafiojpa.models.Cliente;

public interface ClienteServiceI {
	
	List<Cliente> getClientes();
	
	Optional<Cliente> getClienteById(Long id);
	
	Optional<Cliente> updateCliente(Long id, Cliente cliente);
	
	void deleteCliente(Cliente cliente);
	
	void deleteClienteById(Long id);
	
	Optional<Cliente> addCliente(Cliente cliente);
	
	List<Cliente> findByCompleteName(String nombre, String apellidos);
	
	List<Cliente> findByBirthInRange(Date fechaI, Date fechaF);

}
