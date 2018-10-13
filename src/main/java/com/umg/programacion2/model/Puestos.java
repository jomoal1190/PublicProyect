package com.umg.programacion2.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="puestos")
public class Puestos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_puesto")
	private Long idPuesto;
	@Column(name="nombre")
	private String nombre;
	
	
	
	public Long getIdPuesto() {
		return idPuesto;
	}
	public void setIdPuesto(Long idPuesto) {
		this.idPuesto = idPuesto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
	
	
	
}
