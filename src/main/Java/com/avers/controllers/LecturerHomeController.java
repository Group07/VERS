package com.avers.controllers;

import com.avers.Utils.audit.AuditLog;
import com.avers.dto.*;
import com.avers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

/**
 * Created by Amila on 7/14/2015.
 */
@Controller
public class LecturerHomeController {

    final static AuditLog lectureLogger = new AuditLog(LecturerHomeController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/lecturer**", method = RequestMethod.GET)
    public ModelAndView adminPage(Principal principal) {

        ModelAndView model = new ModelAndView();
        model.setViewName("lecturer");

        String userName = principal.getName();
        lectureLogger.log("Admin Logged, UserName = " + userName);

        return model;

    }

    @RequestMapping(value = "/addSubject", method = RequestMethod.POST)
    public ModelAndView addLecturer(@RequestParam String subjectcode,
                                    @RequestParam String subjectname,
                                    @RequestParam String semester,
                                    Principal principal) {

        ModelAndView model = new ModelAndView();
        model.setViewName("lecturer");

        if (subjectcode != null && !subjectcode.trim().isEmpty() & subjectname != null && !subjectname.trim().isEmpty() & semester != null && !semester.trim().isEmpty()) {

            String userName = principal.getName();
            int userID = userService.getUserID(userName);

            SubjectDTO subjectDTO = new SubjectDTO(subjectcode, subjectname, String.valueOf(userID), Integer.parseInt(semester));
            userService.insertSubject(subjectDTO);

            model.addObject("message", "Submitted");

        } else {
            model.addObject("message", "Error With submitted parameters");
        }
        return model;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView addStudent(@RequestParam String username,
                                   @RequestParam String fullName,
                                   @RequestParam String password,
                                   @RequestParam String studentRegNumber,
                                   @RequestParam String dateOfBirth) {

        ModelAndView model = new ModelAndView();

        if (username != null && !fullName.trim().isEmpty() & password != null && !studentRegNumber.isEmpty() && dateOfBirth != null) {


            //insert data into user tables;
            UserDTO user = new UserDTO(username, password);
            userService.insertUser(user);

            //insert data into user_roles;
            UserRolesDTO userRoles = new UserRolesDTO("ROLE_STUDENT", username);
            userService.insertUserRole(userRoles);

            int userID = userService.getUserID(username);

            //insert data into student tables;
            StudentDTO student = new StudentDTO(userID, fullName, studentRegNumber, dateOfBirth);
            userService.insertStudent(student);

            //rending output
            model.addObject("message", "Submitted");
            model.setViewName("lecturer");

        } else {
            model.addObject("message", "Error With submitted parameters");
        }

        return model;

    }

    @RequestMapping(value = "/addMarks", method = RequestMethod.POST)
    public ModelAndView addMarks(@RequestParam Integer studentID,
                                 @RequestParam Integer subjectID,
                                 @RequestParam float marks) {

        BigDecimal marksBD = new BigDecimal(marks);

        //insert marks to a student for subject;
        MarksDTO marksDTO = new MarksDTO(studentID, subjectID, marksBD);
        userService.insertMarks(marksDTO);

        //rending output
        ModelAndView model = new ModelAndView();
        model.addObject("message", "Submitted");
        model.setViewName("lecturer");

        return model;

    }

    @RequestMapping(value = "/getSubjectList", method = RequestMethod.GET)
    public
    @ResponseBody
    List<SubjectDTO> getLectureSubjects(Principal principal) {

        String userName = principal.getName();
        int userID = userService.getUserID(userName);
        return userService.getSubjectsByLecturer(userID);
    }

    @RequestMapping(value = "/getStudentList", method = RequestMethod.GET)
    public
    @ResponseBody
    List<StudentDTO> getLectureStudents() {
        return userService.getAllStudents();
    }


}
