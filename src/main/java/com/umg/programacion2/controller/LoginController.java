package com.umg.programacion2.controller;

import java.util.List;
import  org.springframework.security.core.Authentication;
import javax.servlet.http.HttpServletRequest;
import com.umg.programacion2.model.Menu;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.umg.programacion2.model.User;
import com.umg.programacion2.service.MenuService;
import com.umg.programacion2.serviceImpl.UserServiceImpl;

@Controller
public class LoginController {


    @Autowired
    private UserServiceImpl userService;
    @Autowired MenuService menuService;

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public String login(Model model){
       
        return "login";
    }


    @RequestMapping(value="/registro", method = RequestMethod.GET)
    public String registration(Model model){
        return "registro";
    }

    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public String createNewUser(HttpServletRequest request, HttpServletResponse response, Model model) {
    	User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setLastName(request.getParameter("lastName"));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
           return "registro";
        }
         else {
            userService.saveUser(user);            
            return "redirect:/login";

        }
    }

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        List<Menu> menu = menuService.getAllMenu();
        List<Menu> menuChildren = menuService.getAllChildren();
     
        modelAndView.addObject("menu", menu);
        modelAndView.addObject("children", menuChildren);
        modelAndView.addObject("pagina", "Home");
        
        modelAndView.addObject("userName", "Bienvenido " + user.getName() + " " + user.getLastName());
        modelAndView.addObject("adminMessage","Contendio habil para clientes");
        modelAndView.addObject("emailUser",user.getEmail());
        modelAndView.setViewName("home");
        return modelAndView;
    }


}
