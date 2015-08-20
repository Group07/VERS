package com.avers.controllers;

import com.avers.dto.SubjectDTO;
import com.avers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

/**
 * Created by Amila on 7/14/2015.
 */
@Controller
public class StudentHomeController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/student**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("student");

        return model;

    }

    @RequestMapping(value = "/viewResult", method = RequestMethod.POST)
    public ModelAndView viewResults(@RequestParam String subjectID, Principal principal) {

        ModelAndView model = new ModelAndView();

        model.setViewName("student");

        String userName = principal.getName();
        int userID = userService.getUserID(userName);

        String marks = userService.getResultsForStudents(userID, subjectID);
        model.addObject("marks", marks);

        return model;

    }

    @RequestMapping(value = "/getSubjectListForStudent", method = RequestMethod.GET)
    public
    @ResponseBody
    List<SubjectDTO> getStudentSubjects(Principal principal) {

        String userName = principal.getName();
        int userID = userService.getUserID(userName);
        return userService.getSubjectsByStudent(userID);
    }
}
