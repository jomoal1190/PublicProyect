package com.umg.programacion2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umg.programacion2.model.Cliente;
import com.umg.programacion2.model.Ventas;
@Repository
public interface ClienteRepostory extends CrudRepository<Cliente, Long>{
	List<Cliente> findAll();

}
