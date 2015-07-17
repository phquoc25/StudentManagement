package com.qph.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Quoc on 7/9/2015.
 */
public class DBHelper {
    //private static ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");

    public static void dropTable(String tableName){
    	ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
        SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.createSQLQuery("delete from " + tableName).executeUpdate();
        transaction.commit();
    }
}
