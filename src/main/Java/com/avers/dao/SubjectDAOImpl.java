package com.avers.dao;

import com.avers.dto.SubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Amila on 7/15/2015.
 */
public class SubjectDAOImpl implements SubjectDAO {

    @Autowired
    DataSource dataSource;

    @Override
    public void insertSubject(SubjectDTO subjectDTO) {

        String sql = "INSERT INTO subject" + "(subject_code,subject_name,lecturer_id,semester) VALUES(?,?,?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql, subjectDTO.getSubjectCode(), subjectDTO.getSubjectName(), subjectDTO.getLecturerID(), subjectDTO.getSemester());

    }
}
