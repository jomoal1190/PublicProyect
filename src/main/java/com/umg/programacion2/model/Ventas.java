package com.umg.programacion2.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ventas")
public class Ventas {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idVenta")
	private Long idVenta;
	@Column(name="noFactura")
	private Long noFactura;
	@Column(name="serie")
	private String serie;
	@Column(name="fechaFactura")
	private Date fechaFactura;
	@Column(name="fechaIngreso")
	private Date fechaIngreso;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="idCliente")
	private Cliente cliente;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="idEmpleado")
	private Empleado emppleado;
	
	
	
	
	
	public Long getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}
	public Long getNoFactura() {
		return noFactura;
	}
	public void setNoFactura(Long noFactura) {
		this.noFactura = noFactura;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public Date getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmppleado() {
		return emppleado;
	}
	public void setEmppleado(Empleado emppleado) {
		this.emppleado = emppleado;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


