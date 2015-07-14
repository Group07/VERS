package com.avers.controllers;

import com.avers.Utils.audit.LogWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Welcome");
        model.setViewName("admin");

        //testing user adding functionality
/*      UserDTO user = new UserDTO("test","test");
        userService.insertData(user);*/

        //testing logging functionality
        Logger logger = LoggerFactory.getLogger(AdminHomeController.class);
        logger.info("Admin Logged");

        //testing logging Wrapper functionality
        LogWrapper logWrapper = new LogWrapper(AdminHomeController.class);
        logWrapper.info("Admin Logged");

        return model;

    }

    @RequestMapping(value= "/addLecturer", method = RequestMethod.POST)
    public ModelAndView addLecturer(@RequestParam String username,
                                    @RequestParam  String fullname,
                                    @RequestParam String password) {

        LogWrapper logWrapper = new LogWrapper(AdminHomeController.class);
        logWrapper.info(username +" "+ fullname +" "+ password);

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Welcome");
        model.addObject("message", "Submitted");
        model.setViewName("admin");

        return model;

    }
}
