package com.umg.programacion2.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="puestos")
public class Puestos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_puesto")
	private Long idPuesto;
	@Column(name="nombre")
	private String nombre;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="puesto")
	@JsonManagedReference
	Set<Empleado> empleados = new HashSet<Empleado>();
	
	
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
