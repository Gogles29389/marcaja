package com.example.demo.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marcaje")
public class Marcaje {
	@Id
	private int id_marcaje;
	private String nombre;
	private String departamento;
	private LocalDateTime fecha;

	public Marcaje () {
		
	}

	public Marcaje(int id_marcaje, String Nombre, String Departamento, LocalDateTime Fecha) {
		super();
		this.id_marcaje = id_marcaje;
		this.nombre = Nombre;
		this.departamento = Departamento;
		this.fecha = Fecha;
	}

	public int getId_marcaje() {
		return id_marcaje;
	}

	public void setId_marcaje(int id_marcaje) {
		this.id_marcaje = id_marcaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String Nombre) {
		this.nombre = Nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String Departamento) {
		this.departamento = Departamento;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime Fecha) {
		this.fecha = Fecha;
	}
	
}
 