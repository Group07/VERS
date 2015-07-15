package com.avers.dao;

import com.avers.dto.MarksDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by GoldBows on 7/15/2015.
 */
public class MarksDAOImpl implements MarksDAO {

    @Autowired
    DataSource dataSource;

    @Override
    public void insertMarks(MarksDTO marksDTO) {
        String sql = "INSERT INTO student_by_subjects" + "(student_id, subject_id, marks) VALUES(?,?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql, marksDTO.getStudentID(), marksDTO.getSubjectID(), marksDTO.getMarks());
    }
}
