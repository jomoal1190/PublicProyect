package com.umg.programacion2.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;


import com.umg.programacion2.model.Puestos;



public interface PuestoRepository extends CrudRepository<Puestos, Long>{

	List<Puestos> findAll();
	Puestos findByIdPuesto(Long id);
}
