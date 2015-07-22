package com.avers.dao;

import com.avers.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<StudentDTO> getAllStudents() {
        String sql = "SELECT \n" +
                "    student_id AS studentID,\n" +
                "    student_reg_no AS registerNo,\n" +
                "    student_name AS studentName,\n" +
                "    date_of_birth AS dob\n" +
                "FROM\n" +
                "    student;";

        List<StudentDTO> studentDTOs = new ArrayList<StudentDTO>();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudentID((Integer) row.get("studentID"));
            studentDTO.setFullName((String) row.get("studentName"));
            studentDTO.setStudentRegNumber((String) row.get("registerNo"));
            studentDTOs.add(studentDTO);
        }

        return studentDTOs;
    }
}
