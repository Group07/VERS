package com.avers.services;

import com.avers.dao.*;
import com.avers.dto.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by GoldBows on 7/9/2015.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDao;

    @Autowired
    UserRoleDAO userRoleDAO;

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    SubjectDAO subjectDAO;

    @Autowired
    MarksDAO marksDAO;

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
}