package com.qph.dao;

import com.qph.model.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by Quoc on 7/7/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/applicationContext.xml")
public class StudentDaoTest {

    @Autowired
    IStudentDao studentDaoImpl;

    @Test
    public void testAdd(){
        Student student = new Student();
        student.setStudentId(1071625);
        student.setFirstName("Quoc");
        student.setLastName("PHAN");
        student.setCreatedDate(new Date());
        int studentId = studentDaoImpl.add(student);
        Assert.assertEquals(studentId, student.getStudentId());
    }
}
