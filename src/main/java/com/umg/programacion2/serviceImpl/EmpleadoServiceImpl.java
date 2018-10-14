package com.umg.programacion2.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umg.programacion2.model.Empleado;
import com.umg.programacion2.model.Puestos;
import com.umg.programacion2.repository.EmpleadoRepository;
import com.umg.programacion2.repository.PuestoRepository;
import com.umg.programacion2.service.EmpleadoService;
@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	private static Logger logger = LoggerFactory.getLogger(EmpleadoServiceImpl.class);
	private static final String codigoCorrecto="success";
	private static final String codigoERROR="error";
	
	
	@Autowired PuestoRepository puestoRepository;
	@Autowired EmpleadoRepository empleadoRepository;
	
	@Override
	public List<Puestos> getAllPuestos() {
		List<Puestos> puestos = new ArrayList<Puestos>();
		try {
			puestos =puestoRepository.findAll();
		
		}catch(Exception e)
		{
			puestos = null;
			logger.info("Error "+e);
		}
		return puestos;
	}

	@Override
	public String savePuesto(HttpServletRequest request, HttpServletResponse response) {
		String nombre = request.getParameter("nombre");
		Puestos puesto = new Puestos();
		puesto.setNombre(nombre);
		String res;
		try {
			puestoRepository.save(puesto);
			res=codigoCorrecto;
		}catch(Exception e)
		{
			res=codigoERROR;
			logger.info("Error SavePuesto"+e);	
		}
		
		return res;
	}

	@Override
	public String deletePuesto(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("id"));
		Puestos	 puesto = new Puestos();
		puesto.setIdPuesto(id);
		String respuesta="";
		try {
			puestoRepository.delete(puesto);
			respuesta =codigoCorrecto;
		}catch(Exception e)
		{
			respuesta = codigoERROR;
			logger.info("ERROR deletePuesto"+e);
		}
		return respuesta;
	}


	@Override
	public Puestos getPuestoId(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("id"));
		Puestos	 puesto = new Puestos();
		try {
			puesto =puestoRepository.findByIdPuesto(id);
			
		}catch(Exception e)
		{
		
			logger.info("ERROR deletePuesto"+e);
		}
		return puesto;
	}

	@Override
	public String updatePuesto(HttpServletRequest request, HttpServletResponse response) {
		String nombre = request.getParameter("nombre");
		Long id= Long.parseLong(request.getParameter("id"));
		Puestos puesto = new Puestos();
		puesto.setNombre(nombre);
		puesto.setIdPuesto(id);
		String res;
		try {
			puestoRepository.save(puesto);
			res=codigoCorrecto;
		}catch(Exception e)
		{
			res=codigoERROR;
			logger.info("Error SavePuesto"+e);	
		}
		
		return res;
	}

	@Override
	public List<Empleado> getAllEmpleados() {
		List<Empleado> puestos = new ArrayList<Empleado>();
		try {
			puestos =empleadoRepository.findAll();
		
		}catch(Exception e)
		{
			puestos = null;
			logger.info("Error "+e);
		}
		return puestos;
	}

	
}
