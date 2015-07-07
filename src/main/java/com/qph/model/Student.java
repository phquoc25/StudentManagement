package com.qph.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Quoc on 7/7/2015.
 */
@Entity
@Table(name = "STUDENT")
public class Student implements Serializable{
    private int studentId;
    private String firstName;
    private String lastName;
    private Date createdDate;

    public Student() {

    }

    @Id
    @Column(name = "STUDENT_ID", unique = true, nullable = false)
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    @Column(name = "FIRST_NAME", nullable = false, length = 100)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME", nullable = false, length = 100)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE", nullable = false, length = 7)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
