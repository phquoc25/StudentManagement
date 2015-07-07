package com.qph.dao;

import com.qph.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
