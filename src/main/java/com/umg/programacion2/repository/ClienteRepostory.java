package com.umg.programacion2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.umg.programacion2.model.Cliente;
import com.umg.programacion2.model.Ventas;

public interface ClienteRepostory extends CrudRepository<Cliente, Long>{
	List<Cliente> findAll();

}
