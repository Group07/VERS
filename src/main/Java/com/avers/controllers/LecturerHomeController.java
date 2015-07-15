package com.avers.controllers;

import com.avers.Utils.audit.LogWrapper;
import com.avers.dao.SubjectDAO;
import com.avers.dto.StudentDTO;
import com.avers.dto.SubjectDTO;
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
public class LecturerHomeController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/lecturer**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("lecturer");

        //testing logging Wrapper functionality
        LogWrapper logWrapper = new LogWrapper(LecturerHomeController.class);
        logWrapper.info("lecturer Logged");

        return model;

    }

    @RequestMapping(value = "/addSubject", method = RequestMethod.POST)
    public ModelAndView addLecturer(@RequestParam String subjectcode,
                                    @RequestParam String subjectname,
                                    @RequestParam String semester) {

        ModelAndView model = new ModelAndView();
        model.setViewName("lecturer");

        LogWrapper logWrapper = new LogWrapper(AdminHomeController.class);
        logWrapper.info("request to create subject: subjectcode = " + subjectcode + " & subjectname = " + subjectname + " & semester = " + semester);

        if (subjectcode != null && !subjectcode.trim().isEmpty() & subjectname != null && !subjectname.trim().isEmpty() & semester != null && !semester.trim().isEmpty()) {

            SubjectDTO subjectDTO = new SubjectDTO(subjectcode,subjectname,Integer.parseInt(semester));
            userService.insertSubject(subjectDTO);

            model.addObject("message", "Submitted");

        } else {
            model.addObject("message", "Error With submitted parameters");
        }
        return model;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView addLecturer(@RequestParam String username,
                                    @RequestParam String fullName,
                                    @RequestParam String password,
                                    @RequestParam String studentRegNumber,
                                    @RequestParam String dateOfBirth) {

        LogWrapper logWrapper = new LogWrapper(LecturerHomeController.class);
        logWrapper.info("request to create student: username = " + username + " & full name = " + fullName);

        //insert data into user tables;
        UserDTO user = new UserDTO(username, password);
        userService.insertUser(user);

        //insert data into user_roles;
        UserRolesDTO userRoles = new UserRolesDTO("ROLE_LECTURER", username);
        userService.insertUserRole(userRoles);

        //insert data into student tables;
        StudentDTO student = new StudentDTO(fullName, studentRegNumber, dateOfBirth);
        userService.insertStudent(student);

        //rending output
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Welcome");
        model.addObject("message", "Submitted");
        model.setViewName("lecturer");

        return model;

    }
}
