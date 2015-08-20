package com.avers.dao;

import com.avers.dto.SubjectDTO;

import java.util.List;

/**
 * Created by Amila on 7/15/2015.
 */
public interface SubjectDAO {

    public void insertSubject(SubjectDTO subjectDTO);

    public List<SubjectDTO> getSubjectsByLecturer(int userID);

    List<SubjectDTO> getSubjectsByStudent(int userID);
}
