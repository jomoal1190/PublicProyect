package com.umg.programacion2.controller;

import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umg.programacion2.model.User;
import com.umg.programacion2.serviceImpl.UserServiceImpl;

@Controller
public class LoginController {


    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public String login(Model model){
       
        return "login";
    }


    @RequestMapping(value="/registro", method = RequestMethod.GET)
    public String registration(Model model){
        return "registro";
    }

    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

//    @RequestMapping(value="/home", method = RequestMethod.GET)
//    public ModelAndView home(){
//        ModelAndView modelAndView = new ModelAndView();
//        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findUserByEmail(auth.getName());
//        modelAndView.addObject("userName", "Bienvenido " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
//        modelAndView.addObject("adminMessage","Contendio habil para clientes");
//        modelAndView.setViewName("admin/home");
//        return modelAndView;
//    }
//

}
