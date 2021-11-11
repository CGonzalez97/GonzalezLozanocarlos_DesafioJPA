package com.bootcamp.springdesafiojpa.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.springdesafiojpa.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	List<Cliente> findByNombreAndApellidos(String nombre, String apellidos);	
	
	List<Cliente> findByNombre(String nombre);
	
	List<Cliente> findByFechaNacimientoBetween(Date fechaI, Date fechaF);

}
