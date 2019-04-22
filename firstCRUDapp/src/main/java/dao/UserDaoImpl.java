package dao;

import models.Auto;
import models.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserDaoImpl implements UserDao{
// jPoint 2017 alexei shipilev
    @Override
    public User findByID(int id){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            User user = session.get(User.class, id);
            Hibernate.initialize(user.getAutos());
            tx1.commit();
            session.close();
            return user;
        }
    }

    @Override
    public void save(User user){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.save(user);
            tx1.commit();
            session.close();
        }
    }

    @Override
    public void update(User user){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.update(user);
            tx1.commit();
            session.close();
        }
    }

    @Override
    public void delete(User user){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.delete(user);
            tx1.commit();
            session.close();
        }
    }

    @Override
    public Auto findAutoByID(int id){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            Auto auto = session.get(Auto.class, id);
            tx1.commit();
            session.close();
            return auto;
        }
    }

    @Override
    public List findAll(){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            List users = session.createQuery("From User").list();
            tx1.commit();
            session.close();
            return users;
        }
    }

    @Override
    public void addAuto(User user, Auto auto) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction tx1 = session.beginTransaction();
            session.save(auto);
            user.getAutos().add(auto);
            session.update(user);
            tx1.commit();
            session.close();
        }
    }
}
