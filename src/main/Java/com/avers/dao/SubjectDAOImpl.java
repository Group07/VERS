package com.avers.dao;

import com.avers.dto.SubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<SubjectDTO> getSubjectsByLecturer(int userID) {

        String sql = "select subject_id, subject_code, subject_name, semester from subject where lecturer_id=" + userID;
        List<SubjectDTO> subjectDTOs = new ArrayList<SubjectDTO>();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            SubjectDTO subjectDTO = new SubjectDTO();
            subjectDTO.setSubjectCode((String)row.get("subject_code"));
            subjectDTO.setSubjectID((String) row.get("subject_id"));
            subjectDTO.setSubjectName((String) row.get("subject_name"));
            subjectDTO.setSubjectName((String) row.get("semester"));

            subjectDTOs.add(subjectDTO);
        }

        return subjectDTOs;
    }
}
