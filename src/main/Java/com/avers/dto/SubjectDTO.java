package com.avers.dto;

/**
 * Created by Amila on 7/15/2015.
 */
public class SubjectDTO {

    public String subjectCode;
    public String SubjectName;
    public String lecturerID;
    public int semester;

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public String getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public SubjectDTO(String subjectCode, String subjectName, String lecturerID, int semester) {
        this.subjectCode = subjectCode;
        SubjectName = subjectName;
        this.lecturerID = lecturerID;
        this.semester = semester;
    }

    public SubjectDTO(String subjectName, String subjectCode, int semester) {
        SubjectName = subjectName;
        this.subjectCode = subjectCode;
        this.semester = semester;
    }

    public SubjectDTO() {
    }
}
