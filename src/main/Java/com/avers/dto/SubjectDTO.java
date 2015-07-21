package com.avers.dto;

/**
 * Created by Amila on 7/15/2015.
 */
public class SubjectDTO {

    private String subjectID;
    private String subjectCode;
    private String SubjectName;
    private String lecturerID;
    private int semester;

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

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
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
