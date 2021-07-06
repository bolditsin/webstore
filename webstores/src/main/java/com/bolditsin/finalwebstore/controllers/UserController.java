package com.bolditsin.finalwebstore.controllers;

import com.bolditsin.finalwebstore.DAO.UserDAO;
import com.bolditsin.finalwebstore.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserDAO userDAO;

    public UserController(UserDAO userDAO){
        this.userDAO=userDAO;
    }
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDAO.index());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String showUsers(@PathVariable("id") int id, Model model){
        model.addAttribute("user",userDAO.showUser(id));
        return "users/showuser";
    }
    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());

        return "users/new";
    }
    @PostMapping
    public String create(@ModelAttribute("user") User user){
        userDAO.save(user);
        return "redirect:/users";
    }
}
