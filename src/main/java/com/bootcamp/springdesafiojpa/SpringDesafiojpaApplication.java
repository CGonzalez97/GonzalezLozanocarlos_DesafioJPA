package com.bootcamp.springdesafiojpa;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bootcamp.springdesafiojpa.models.Cliente;
import com.bootcamp.springdesafiojpa.services.ClienteServiceImpl;

@SpringBootApplication
public class SpringDesafiojpaApplication implements CommandLineRunner {
	
	@Autowired
	private ClienteServiceImpl clienteServicio;

	public static void main(String[] args) {
		SpringApplication.run(SpringDesafiojpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cliente cliente1 = new Cliente("Paco","Romero",Date.valueOf("1997-05-05"),"12341234A");
		Cliente cliente2 = new Cliente("María","Pérez",Date.valueOf("1993-11-21"),"56785678B");
		Cliente cliente3 = new Cliente("Alberto","Juarez",Date.valueOf("1987-04-07"),"13572468C");
		
		clienteServicio.addCliente(cliente1);
		clienteServicio.addCliente(cliente2);
		clienteServicio.addCliente(cliente3);
		
		System.out.println("Buscar todos los clientes:");
		List<Cliente> listadoClientes = clienteServicio.getClientes();
		System.out.println(listadoClientes);
		
		System.out.println("\nBuscar el primer cliente:");
		Cliente clienteAux = clienteServicio.getClienteById(listadoClientes.get(0).getId()).get();
		System.out.println(clienteAux);
		
		System.out.println("\nActualizar cliente:");
		clienteAux.setNombre("Paquito");
		clienteAux = clienteServicio.updateCliente(clienteAux.getId(), clienteAux).get();
		System.out.println(clienteAux);
		
		System.out.println("\nEliminar cliente por id:");
		clienteServicio.deleteClienteById(clienteAux.getId());
		System.out.println("Comprobación:");
		listadoClientes = clienteServicio.getClientes();
		System.out.println(listadoClientes);
		
		System.out.println("\nEliminar por entidad:");
		clienteServicio.deleteCliente(listadoClientes.get(0));
		listadoClientes = clienteServicio.getClientes();
		System.out.println("Comprobación:\n"+listadoClientes);
		
		
				
		
	}

}
