package com.avers.controllers;

import com.avers.dto.LecturerDTO;
import com.avers.dto.UserDTO;
import com.avers.dto.UserRolesDTO;
import com.avers.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Amila on 7/14/2015.
 */
@Controller
public class AdminHomeController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        //model.addObject("title", "Welcome");
        model.setViewName("admin");

        //testing logging Wrapper functionality
        final Logger logger = LoggerFactory.getLogger(AdminHomeController.class);

        //testing Logback
        logger.debug("Admin Logged");
        logger.info("Admin Logged");
        logger.warn("Admin Logged");

        return model;

    }

    @RequestMapping(value = "/addLecturer", method = RequestMethod.POST)
    public ModelAndView addLecturer(@RequestParam String username,
                                    @RequestParam String fullname,
                                    @RequestParam String password) {

        ModelAndView model = new ModelAndView();
        model.setViewName("admin");

        if (username != null && !username.trim().isEmpty() & fullname != null && !fullname.trim().isEmpty() & password != null && !password.trim().isEmpty()) {

            //insert data into user tables;
            UserDTO user = new UserDTO(username, password);
            userService.insertUser(user);

            //insert data into user_roles;
            UserRolesDTO userRoles = new UserRolesDTO("ROLE_LECTURER", username);
            userService.insertUserRole(userRoles);

            //get userID of inserted lecturer
            int userID = userService.getUserID(username);

            //insert data into lecturer
            LecturerDTO lecturer = new LecturerDTO(userID, fullname, 1); //FIXME privilege id hardcoded to 1
            userService.insertLecturer(lecturer);

            model.addObject("message", "Submitted");

        } else {
            model.addObject("message", "Error With submitted parameters");
        }

        return model;

    }
}
