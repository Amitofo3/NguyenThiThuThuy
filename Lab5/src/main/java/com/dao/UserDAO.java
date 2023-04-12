package com.dao;

import org.hibernate.Session;

import com.Hibernate.Hibernate;
import com.entities.User;
public class UserDAO {
    static Session session = null;

    public UserDAO() {}
    public void create(User user){
        session = Hibernate.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

}
