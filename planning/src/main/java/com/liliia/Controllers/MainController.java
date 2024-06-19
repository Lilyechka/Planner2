package com.liliia.Controllers;

import com.liliia.DataTransferObjects.DTORegister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        DTORegister user = new DTORegister();
        model.addAttribute("user", user);
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/tasks")
    public String getTasksPage() {
        return "tasks";
    }

}