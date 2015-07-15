package com.avers.dao;

import com.avers.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by GoldBows on 7/15/2015.
 */
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    DataSource dataSource;

    @Override
    public void insertStudent(StudentDTO student) {
        String sql = "INSERT INTO student" + "(student_name,student_reg_no,date_of_birth) VALUES(?,?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql, student.getFullName(), student.getStudentRegNumber(), student.getDateOfBirth());
    }
}
