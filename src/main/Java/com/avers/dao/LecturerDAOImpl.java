package com.avers.dao;

import com.avers.dto.LecturerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Amila on 7/16/2015.
 */
public class LecturerDAOImpl implements LecturerDAO {

    @Autowired
    DataSource dataSource;

    @Override
    public void insertLecturer(LecturerDTO lecturer) {

        String sql = "INSERT INTO lecturer" + "(lecturer_id,lecturer_name,privilege_id) VALUES(?,?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql, lecturer.getLectureID(), lecturer.getFullName(), lecturer.getPrivilegeID());

    }
}
