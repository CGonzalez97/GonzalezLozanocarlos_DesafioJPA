package com.bootcamp.springdesafiojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.springdesafiojpa.models.Cliente;
import com.bootcamp.springdesafiojpa.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteServiceI{
	
	@Autowired
	private ClienteRepository repositorio;

	@Override
	public List<Cliente> getClientes() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Cliente> getClienteById(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public Optional<Cliente> updateCliente(Long id, Cliente cliente) {
		Optional<Cliente> clienteAux = repositorio.findById(id);
		if(!clienteAux.isEmpty()) {
			cliente.setId(clienteAux.get().getId());
			clienteAux = Optional.of(repositorio.save(cliente));
		}
		return clienteAux;
	}

	@Override
	public void deleteCliente(Cliente cliente) {
		repositorio.delete(cliente);
	}

	@Override
	public void deleteClienteById(Long id) {
		repositorio.deleteById(id);
	}

	@Override
	public Optional<Cliente> addCliente(Cliente cliente) {		
		return Optional.of(repositorio.save(cliente));
	}

	@Override
	public List<Cliente> findByCompleteName(String nombre, String apellidos) {
		return repositorio.findByNombreAndApellidos(nombre, apellidos);
	}
	
	

}
