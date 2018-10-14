package com.umg.programacion2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.umg.programacion2.model.Menu;



public interface MenuRepository extends CrudRepository<Menu, Long>{
	List<Menu> findAll();
	
	@Query("Select m from Menu m where m.padre!=0")
	List<Menu> findAllChildren();

}
