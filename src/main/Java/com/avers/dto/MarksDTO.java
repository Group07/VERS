package com.avers.dto;

import java.math.BigDecimal;

/**
 * Created by GoldBows on 7/15/2015.
 */
public class MarksDTO {

    private Integer studentID;
    private Integer subjectID;
    private BigDecimal marks;

    public MarksDTO(Integer studentID, Integer subjectID, BigDecimal marks) {
        this.studentID = studentID;
        this.subjectID = subjectID;
        this.marks = marks;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public Integer getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Integer subjectID) {
        this.subjectID = subjectID;
    }

    public BigDecimal getMarks() {
        return marks;
    }

    public void setMarks(BigDecimal marks) {
        this.marks = marks;
    }
}