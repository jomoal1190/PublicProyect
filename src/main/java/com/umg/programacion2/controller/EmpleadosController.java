package com.umg.programacion2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.umg.programacion2.model.Puestos;
import com.umg.programacion2.service.EmpleadoService;

@Controller
public class EmpleadosController {

	@Autowired EmpleadoService empleadoService;
	
	
	 @RequestMapping(value="/listPuestos", method = RequestMethod.GET)
	    public String puestos(Model model) {
		 List<Puestos> puestos = empleadoService.getAllPuestos();
		 model.addAttribute("puestos", puestos);
	        return "listPuestos";
	    }
	 
	 @RequestMapping(value="/gestion/puestos/listPuestos", method = RequestMethod.GET)
	    public String puestos2(Model model) {
		 List<Puestos> puestos = empleadoService.getAllPuestos();
		 model.addAttribute("puestos", puestos);
	        return "gestion/puestos/listPuestos";
	    }
	 
	 @RequestMapping(value="/gestion/puestos/addPuesto", method = RequestMethod.GET)
	    public String addPuesto(Model model) {
		 
	        return "gestion/puestos/addPuesto";
	    }
	 
	 @RequestMapping(value="/gestion/puestos/addPuesto", method = RequestMethod.POST)
	    public String savePuesto(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		 	String resp = empleadoService.savePuesto(request, response);
		 	model.addAttribute("codigo", resp);
	        return "gestion/puestos/listPuestos";
	    }
	 
	 @RequestMapping(value="/gestion/puestos/eliminarPuesto", method = RequestMethod.POST)
		public @ResponseBody String deletePuesto(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes)
		{
			String respuesta = empleadoService.deletePuesto(request, response);
			return respuesta;
			
		}
	 
	 @RequestMapping(value="/gestion/puestos/updatePuesto", method = RequestMethod.GET)
	    public String updatePuesto(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes,Model model) {
		 	
		 	Puestos puesto = empleadoService.getPuestoId(request, response);
		 	model.addAttribute("puesto", puesto);
	        return "gestion/puestos/updatePuesto";
	    }
	 
}
