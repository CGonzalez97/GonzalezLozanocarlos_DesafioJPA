package com.bootcamp.springdesafiojpa.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "APELLIDOS", nullable = false)
	private String apellidos;
	
	@Column(name = "FECHA_NACIMIENTO")
	private Date fechaNacimiento;
	
	@Column(name = "NUMERO_SEGURIDAD_SOCIAL")
	private String nSeguridadSocial;

	public Cliente() {
		super();
	}

	public Cliente(String nombre, String apellidos, Date fechaNacimiento, String nSeguridadSocial) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.nSeguridadSocial = nSeguridadSocial;
	}

	public Cliente(Long id, String nombre, String apellidos, Date fechaNacimiento, String nSeguridadSocial) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.nSeguridadSocial = nSeguridadSocial;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getnSeguridadSocial() {
		return nSeguridadSocial;
	}

	public void setnSeguridadSocial(String nSeguridadSocial) {
		this.nSeguridadSocial = nSeguridadSocial;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + ", nSeguridadSocial=" + nSeguridadSocial + "]";
	}
	
	
	
	

}
