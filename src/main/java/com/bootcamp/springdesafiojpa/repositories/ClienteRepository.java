package com.bootcamp.springdesafiojpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.springdesafiojpa.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
