package com.qph.services;

import com.qph.dao.IStudentDao;
import com.qph.model.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;

/**
 * Created by Quoc on 6/28/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/applicationContext.xml")
public class StudentServicesTest {

    @InjectMocks
    @Autowired
    IStudentServices studentServices;
    @Mock
    IStudentDao studentDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        /*when(studentDao.add(any(Student.class))).thenReturn(10718250);
        when(studentDao.findStudentById(any(Integer.class))).thenReturn(new Student());*/
    }

    @Test
    public void addTest() {
        Student student = new Student();
        int expectedResult = 10718250;
        int actualResult = studentServices.add(student);
        Assert.assertEquals(expectedResult, actualResult);
    }
}
