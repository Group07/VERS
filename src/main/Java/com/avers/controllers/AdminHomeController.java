package com.avers.controllers;

import com.avers.Utils.audit.LogWrapper;
import com.avers.dto.UserDTO;
import com.avers.dto.UserRolesDTO;
import com.avers.services.UserService;
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
        model.addObject("title", "Welcome");
        model.setViewName("admin");

        //testing user adding functionality
/*        UserDTO user = new UserDTO("test","test");
        userService.insertData(user);*/

        //testing slf4j log
/*        Logger logger = LoggerFactory.getLogger(AdminHomeController.class);
        logger.info("Admin Logged");*/

        //testing logging Wrapper functionality
        LogWrapper logWrapper = new LogWrapper(AdminHomeController.class);
        logWrapper.info("Admin Logged");

        return model;

    }

    @RequestMapping(value = "/addLecturer", method = RequestMethod.POST)
    public ModelAndView addLecturer(@RequestParam String username,
                                    @RequestParam String fullname,
                                    @RequestParam String password) {

        LogWrapper logWrapper = new LogWrapper(AdminHomeController.class);
        logWrapper.info(username + " " + fullname + " " + password);

        //insert data into user tables;
        UserDTO user = new UserDTO(username, password);
        userService.insertUser(user);

        //insert data into user_roles;
        UserRolesDTO userRoles = new UserRolesDTO("ROLE_LECTURER", username);
        userService.insertUserRole(userRoles);


        ModelAndView model = new ModelAndView();
        model.addObject("title", "Welcome");
        model.addObject("message", "Submitted");
        model.setViewName("admin");

        return model;

    }
}
