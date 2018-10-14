package com.umg.programacion2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.umg.programacion2.model.Cliente;
import com.umg.programacion2.model.Menu;
import com.umg.programacion2.model.Puestos;
import com.umg.programacion2.service.ClienteService;
import com.umg.programacion2.service.MenuService;

@Controller
public class ClienteController {
	@Autowired MenuService menuService;
	@Autowired ClienteService clienteSerice;
	
	
	@RequestMapping(value={"/ventas/clientes/listClientes"}, method = RequestMethod.GET)
    public String listPuestos(Model model) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = clienteSerice.getAllClient();
		
		model.addAttribute("clientes", clientes);
//	 	SIEMPRE LLAMAR A ESTA FUNCION
	 	List<Menu> menu = menuService.getAllMenu();
        List<Menu> menuChildren = menuService.getAllChildren();
       
    	model.addAttribute("menu", menu);
    	model.addAttribute("children", menuChildren);
    	model.addAttribute("pagina", "Clientes");
        return "ventas/clientes/listClientes";
    }
}
