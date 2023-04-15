/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourERP.knightvision.controller;

import clases.usuario.User;
import com.ourERP.knightvision.service.IuserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Alfred
 */
@Controller
public class UsersController {

    @Autowired
    private IuserService serviceUser;

    @GetMapping("/registrousers")
    public String irARegistroUsers(Model model) {
        model.addAttribute("nav", "Registro");
        List<User> users = serviceUser.listar();
        model.addAttribute("users", users);
        model.addAttribute("user", new User()); // Add an empty User object to the model
        return "registrousers";
    }

    @PostMapping("/registroUsers") // Update the URL to match the form action
    public String save(User u, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("nav", "Registro");
            List<User> users = serviceUser.listar();
            model.addAttribute("users", users);
            return "registrousers";
        }
        serviceUser.save(u);
        return "redirect:/registrousers";
    }

    @GetMapping("/eliminarusuario/{userid}")
    public String delete(Model model, @PathVariable int userid) {
        serviceUser.delete(userid);
        return "redirect:/registrousers";
    }
    
    
    @GetMapping("/editarusuario/{userid}")
    public String editar(Model model, User user) {
        model.addAttribute("users", serviceUser.editar(user));
        return "redirect:/registrousers";
    }
}