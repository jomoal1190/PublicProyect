package com.umg.programacion2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.umg.programacion2.model.Empleado;
import com.umg.programacion2.model.Menu;
import com.umg.programacion2.model.Puestos;
import com.umg.programacion2.service.EmpleadoService;
import com.umg.programacion2.service.MenuService;
import com.umg.programacion2.serviceImpl.EmpleadoServiceImpl;

@Controller
public class EmpleadosController {

	private static Logger logger = LoggerFactory.getLogger(EmpleadosController.class);
	@Autowired EmpleadoService empleadoService;
	@Autowired MenuService menuService;
	
	
//	 @RequestMapping(value="/listPuestos", method = RequestMethod.GET)
//	    public String puestos(Model model) {
//		 List<Puestos> puestos = empleadoService.getAllPuestos();
//		 model.addAttribute("puestos", puestos);
//	        return "listPuestos";
//	    }
	 
	 @RequestMapping(value={"/ventas/empleados/puestos/listPuestos"}, method = RequestMethod.GET)
	    public String listPuestos(Model model) {
		 List<Puestos> puestos = empleadoService.getAllPuestos();
		 model.addAttribute("puestos", puestos);
		 
		 
//		 	SIEMPRE LLAMAR A ESTA FUNCION
		 	List<Menu> menu = menuService.getAllMenu();
	        List<Menu> menuChildren = menuService.getAllChildren();
	       
	    	model.addAttribute("menu", menu);
	    	model.addAttribute("children", menuChildren);
	        return "ventas/empleados/puestos/listPuestos";
	    }
	 
	 @RequestMapping(value="/gestion/puestos/addPuesto", method = RequestMethod.GET)
	    public String addPuesto(Model model) {
//		 	SIEMPRE LLAMAR A ESTA FUNCION
		 	List<Menu> menu = menuService.getAllMenu();
	        List<Menu> menuChildren = menuService.getAllChildren();
	       
	    	model.addAttribute("menu", menu);
	    	model.addAttribute("children", menuChildren);
	        return "ventas/empleados/puestos/addPuesto";
	    }
	 
	 @RequestMapping(value="/ventas/empleados/puestos/addPuesto", method = RequestMethod.POST)
	    public String savePuesto(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		 	String resp = empleadoService.savePuesto(request, response);
		 	model.addAttribute("codigo", resp);
		 	
		 	
//		 	SIEMPRE LLAMAR A ESTA FUNCION
		 	List<Menu> menu = menuService.getAllMenu();
	        List<Menu> menuChildren = menuService.getAllChildren();
	       
	    	model.addAttribute("menu", menu);
	    	model.addAttribute("children", menuChildren);
		 	
	        return "redirect:/ventas/empleados/puestos/listPuestos";
	    }
	 
	 @RequestMapping(value="/ventas/empleados/puestos/eliminarPuesto", method = RequestMethod.POST)
		public @ResponseBody String deletePuesto(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes)
		{
			String respuesta = empleadoService.deletePuesto(request, response);
			return respuesta;
			
		}
	 
	 @RequestMapping(value="/ventas/empleados/puestos/updatePuesto", method = RequestMethod.GET)
	    public String updatePuesto(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes,Model model) {
		 	
		 	Puestos puesto = empleadoService.getPuestoId(request, response);
		 	model.addAttribute("puesto", puesto);
		 	
		 	
//		 	SIEMPRE LLAMAR A ESTA FUNCION
		 	List<Menu> menu = menuService.getAllMenu();
	        List<Menu> menuChildren = menuService.getAllChildren();
	       
	    	model.addAttribute("menu", menu);
	    	model.addAttribute("children", menuChildren);
	        return "ventas/empleados/puestos/updatePuesto";
	    }
	 
	 @RequestMapping(value="/ventas/empleados/puestos/updatePuesto", method = RequestMethod.POST)
	    public String updatePuesto(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		 	logger.info("LLEGAMOS A UPDATE");
		 	
		 	String resp = empleadoService.updatePuesto(request, response);
		 	model.addAttribute("codigo", resp);
		 	
//		 	SIEMPRE LLAMAR A ESTA FUNCION
		 	List<Menu> menu = menuService.getAllMenu();
	        List<Menu> menuChildren = menuService.getAllChildren();
	       
	    	model.addAttribute("menu", menu);
	    	model.addAttribute("children", menuChildren);
	        return "redirect:/ventas/empleados/puestos/listPuestos";
	    }
	 
	 
	 
	 @RequestMapping(value={"/ventas/empleados/listEmpleados"}, method = RequestMethod.GET)
	    public String listEmpleados(Model model) {
		 List<Empleado> empleados = empleadoService.getAllEmpleados();
		 model.addAttribute("empleados", empleados);
		 
		 
//		 	SIEMPRE LLAMAR A ESTA FUNCION
		 	List<Menu> menu = menuService.getAllMenu();
	        List<Menu> menuChildren = menuService.getAllChildren();
	       
	    	model.addAttribute("menu", menu);
	    	model.addAttribute("children", menuChildren);
	        return "ventas/empleados/listEmpleados";
	    }
	 
	 @RequestMapping(value={"/ventas/empleados/addEmpleado"}, method = RequestMethod.GET)
	 public String addEmpleado(Model model) {
		 	List<Puestos> puestos = empleadoService.getAllPuestos();
		 	model.addAttribute("puestos", puestos);
		 
//		 	SIEMPRE LLAMAR A ESTA FUNCION
		 	List<Menu> menu = menuService.getAllMenu();
	        List<Menu> menuChildren = menuService.getAllChildren();
	       
	    	model.addAttribute("menu", menu);
	    	model.addAttribute("children", menuChildren);
	        return "ventas/empleados/addEmpleado";
	    }
	 
	 
	 
}
