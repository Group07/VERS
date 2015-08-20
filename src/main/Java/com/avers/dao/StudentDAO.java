package com.avers.dao;

import com.avers.dto.StudentDTO;

import java.util.List;

/**
 * Created by GoldBows on 7/15/2015.
 */
public interface StudentDAO {
    void insertStudent(StudentDTO student);
    public List<StudentDTO> getAllStudents();
    String getResultsForStudents(int userID, String subjectId);
}
