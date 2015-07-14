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
public class LecturerHomeController {

    @RequestMapping(value = "/lecturer**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Login Form - Database Authentication");
        model.addObject("message", "This page is for ROLE_LECTURER only!");
        model.setViewName("lecturer");

        //testing logging Wrapper functionality
        LogWrapper logWrapper = new LogWrapper(LecturerHomeController.class);
        logWrapper.info("lecturer Logged");

        return model;

    }
}
