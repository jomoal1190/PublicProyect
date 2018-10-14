package com.umg.programacion2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.umg.programacion2.model.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long>{
	
	List<Empleado> findAll();
}
