package com.qph.dao;

import com.qph.common.DBHelper;
import com.qph.model.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
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
    
    @Autowired
    SessionFactory sessionFactory;
    
    @Before
    public void setup(){

    }

    @After
    public void tearDown(){
    	Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.createSQLQuery("delete from STUDENT").executeUpdate();
        transaction.commit();
    }

    @Test
    public void testAdd(){
        Student student = new Student();
        student.setStudentId(1071625);
        student.setFirstName("Quoc");
        student.setLastName("PHAN");
        student.setCreatedDate(new Date());
        int studentId = studentDaoImpl.add(student);

        Student studentFound = studentDaoImpl.searchByID(student.getStudentId());
        Assert.assertEquals(studentId, student.getStudentId());
        Assert.assertNotNull(studentFound);
        Assert.assertEquals(studentFound, student);
    }

   // @Test
    public void testSearchFound(){
        Student student = new Student();
        student.setStudentId(1071625);
        student.setFirstName("Quoc");
        student.setLastName("PHAN");
        student.setCreatedDate(new Date());
        int studentId = studentDaoImpl.add(student);
        Student studentFound = studentDaoImpl.searchByID(1071625);
        Assert.assertEquals(student, studentFound);
    }
}
