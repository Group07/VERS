package com.avers.controllers;

import com.avers.Utils.audit.LogWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Amila on 7/14/2015.
 */
@Controller
public class AdminHomeController {

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Login Form - Database Authentication");
        model.addObject("message", "This page is for ROLE_ADMIN only!");
        model.setViewName("admin");

        //testing user adding functionality
/*      UserDTO user = new UserDTO("test","test");
        userService.insertData(user);*/

        //testing logging functionality
        Logger logger = LoggerFactory.getLogger(WebHomeController.class);
        logger.info("Admin Logged");

        //testing logging Wrapper functionality
        LogWrapper logWrapper = new LogWrapper(WebHomeController.class);
        logWrapper.info("Admin Logged");

        return model;

    }
}