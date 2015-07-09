package com.avers.controllers;

import com.avers.dto.UserDTO;
import com.avers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by GoldBows on 7/9/2015.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/insert")
    public String inserData(@ModelAttribute UserDTO user) {
        if (user != null)
            userService.insertData(user);
        return "redirect:/getList";
    }


}
