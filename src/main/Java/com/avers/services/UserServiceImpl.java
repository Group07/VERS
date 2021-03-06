package com.avers.services;

import com.avers.dao.*;
import com.avers.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by GoldBows on 7/9/2015.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDao")
    UserDAO userDao;

    @Autowired
    UserRoleDAO userRoleDAO;

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    SubjectDAO subjectDAO;

    @Autowired
    MarksDAO marksDAO;

    @Autowired
    LecturerDAO lecturerDAO;

    @Override
    public void insertUser(UserDTO user) {
        userDao.insertUser(user);
    }

    @Override
    public void insertUserRole(UserRolesDTO userRolesDTO) {
        userRoleDAO.insertRole(userRolesDTO);
    }

    @Override
    public void insertStudent(StudentDTO student) {
        studentDAO.insertStudent(student);
    }

    @Override
    public void insertSubject(SubjectDTO subject) {
        subjectDAO.insertSubject(subject);
    }

    @Override
    public int getUserID(String userName) {
        return userDao.getUserID(userName);
    }

    public void insertMarks(MarksDTO marksDTO) {
        marksDAO.insertMarks(marksDTO);
    }

    @Override
    public void insertLecturer(LecturerDTO lecturer) {
        lecturerDAO.insertLecturer(lecturer);
    }

    @Override
    public List<SubjectDTO> getSubjectsByLecturer(int userID) {
        return subjectDAO.getSubjectsByLecturer(userID);
    }

    @Override
    public List<SubjectDTO> getSubjectsByStudent(int userID) {
        return subjectDAO.getSubjectsByStudent(userID);    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public String getResultsForStudents(int userID, String subjectId) {
        return studentDAO.getResultsForStudents(userID, subjectId);
    }
}