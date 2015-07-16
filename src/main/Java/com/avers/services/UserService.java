package com.avers.services;

import com.avers.dto.*;

/**
 * Created by GoldBows on 7/9/2015.
 */
public interface UserService {
    void insertUser(UserDTO user);

    void insertUserRole(UserRolesDTO userRolesDTO);

    void insertStudent(StudentDTO student);

    void insertSubject(SubjectDTO subject);

    int getUserID(String userName);

    void insertMarks(MarksDTO marksDTO);

    void insertLecturer(LecturerDTO lecturer);
}
