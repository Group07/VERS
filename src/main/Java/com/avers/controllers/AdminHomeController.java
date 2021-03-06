package com.avers.controllers;

import com.avers.Utils.audit.AuditLog;
import com.avers.dto.LecturerDTO;
import com.avers.dto.UserDTO;
import com.avers.dto.UserRolesDTO;
import com.avers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by Amila on 7/14/2015.
 */
@Controller
public class AdminHomeController {

    final static AuditLog adminLogger = new AuditLog(AdminHomeController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage(Principal principal) {

        ModelAndView model = new ModelAndView();
        model.setViewName("admin");

        String userName = principal.getName();
        adminLogger.log("Admin Logged, UserName = " + userName);

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
