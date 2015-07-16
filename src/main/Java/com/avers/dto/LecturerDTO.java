package com.avers.dto;

/**
 * Created by Amila on 7/16/2015.
 */
public class LecturerDTO {

    private int lectureID;
    private String fullName;
    private int privilegeID;

    public int getLectureID() {
        return lectureID;
    }

    public void setLectureID(int lectureID) {
        this.lectureID = lectureID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPrivilegeID() {
        return privilegeID;
    }

    public void setPrivilegeID(int privilegeID) {
        this.privilegeID = privilegeID;
    }

    public LecturerDTO(int lectureID, String fullName, int privilegeID) {
        this.lectureID = lectureID;
        this.fullName = fullName;
        this.privilegeID = privilegeID;
    }

    public LecturerDTO() {
    }
}
