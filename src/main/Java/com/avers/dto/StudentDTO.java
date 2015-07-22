package com.avers.dto;

/**
 * Created by GoldBows on 7/15/2015.
 */
public class StudentDTO {

    private Integer studentID;
    private String fullName;
    private String studentRegNumber;
    private String dateOfBirth;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentRegNumber() {
        return studentRegNumber;
    }

    public void setStudentRegNumber(String studentRegNumber) {
        this.studentRegNumber = studentRegNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public StudentDTO(String fullName, String studentRegNumber, String dateOfBirth) {
        this.fullName = fullName;
        this.studentRegNumber = studentRegNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public StudentDTO(Integer studentID, String fullName, String studentRegNumber, String dateOfBirth) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.studentRegNumber = studentRegNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public StudentDTO() {

    }


}
