package com.liliia.Controllers;

import com.liliia.model.User;
import com.liliia.service.UserService;
import com.liliia.DataTransferObjects.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public User registerUser(@RequestBody @Valid DTORegister userDTO) {
        User user = userService.registerNewUserAccount(userDTO);
        return user;
    }

}
