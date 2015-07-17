package com.qph.dao;

import com.qph.model.Student;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Quoc on 7/7/2015.
 */
@Repository
public class StudentDaoImpl implements IStudentDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int add(Student student) {
        Session currentSession;
        Transaction transaction;
        int returnId;
        currentSession = sessionFactory.getCurrentSession();
        transaction = currentSession.beginTransaction();
        currentSession.save(student);
        returnId = student.getStudentId();
        transaction.commit();
        return returnId;
    }

    @Override
    public Student searchByID(int studentId) {
        Session currentSession;
        currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        Query query = currentSession.createQuery("from Student where studentId = :studentId");
        query.setParameter("studentId", studentId);
        List<Student> studentList = query.list();
        return studentList.get(0);
    }
}
