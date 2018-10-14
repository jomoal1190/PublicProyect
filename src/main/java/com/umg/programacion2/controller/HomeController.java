package com.umg.programacion2.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.umg.programacion2.model.Menu;
import com.umg.programacion2.service.MenuService;

@Controller
public class HomeController {
	
	private static Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired MenuService menuService;
	
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String home(Model model) {
    	
    	
        List<Menu> menu = menuService.getAllMenu();
        List<Menu> menuChildren = menuService.getAllChildren();
       
    	model.addAttribute("menu", menu);
    	model.addAttribute("children", menuChildren);
        return "home";
    }
    
   
}
