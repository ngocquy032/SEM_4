package com.example.thispring.Controller;

import com.example.thispring.Repository.RoleRepository;
import com.example.thispring.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/")
    public String index(Model model) {
        String loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("user", loggedInUser);
        return "index";
    }

}
