package com.avers.services;

import com.avers.dao.MarksDAO;
import com.avers.dao.StudentDAO;
import com.avers.dao.SubjectDAO;
import com.avers.dao.UserDAO;
import com.avers.dao.UserRoleDAO;
import com.avers.dto.MarksDTO;
import com.avers.dto.StudentDTO;
import com.avers.dto.SubjectDTO;
import com.avers.dto.UserDTO;
import com.avers.dto.UserRolesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
    public void insertMarks(MarksDTO marksDTO) {
        marksDAO.insertMarks(marksDTO);
    }
}
