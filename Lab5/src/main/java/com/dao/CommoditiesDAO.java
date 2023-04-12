package com.dao;

import org.hibernate.Session;

import com.Hibernate.Hibernate;
import com.entities.Commoditites;
public class CommoditiesDAO {
    static Session session = null;

    public void CommodititesDAO() {}
    public void create(Commoditites commoditites){
        session = Hibernate.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(commoditites);
        session.getTransaction().commit();
        session.close();
    }
}
