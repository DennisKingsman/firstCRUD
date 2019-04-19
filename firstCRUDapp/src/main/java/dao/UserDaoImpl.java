package dao;

import models.Auto;
import models.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserDaoImpl implements UserDao {
// jPoint 2017 alexei shipilev

    @Override
    public User findByID(int id) {
        /*
        Сессию необходимо обязательно закрывать, даже если вылетит исключение.
        Можно явно это делать в блоке finally или использовать try с ресурсами
         */
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            User user = session.get(User.class, id);
            Hibernate.initialize(user.getAutos());
            tx1.commit();
            return user;
        }

       // return (User) HibernateSessionFactoryUtil.getSessionFactory().openStatelessSession().get(User.class, id);
    }

    @Override
    public void save(User user){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.save(user);
            tx1.commit();
        }
    }

    @Override
    public void update(User user){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.update(user);
            tx1.commit();
        }
    }

    @Override
    public void delete(User user){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.delete(user);
            tx1.commit();
        }
    }

    @Override
    public Auto findAutoByID(int id){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            Auto auto = session.get(Auto.class, id);
            tx1.commit();
            return auto;
        }

        //return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);
    }

    @Override
    public List findAll(){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            List users = session.createQuery("From User").list();
            tx1.commit();
            return users;
        }
    }

    @Override
    public void addAuto(User user, Auto auto) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.save(auto);
            user.getAutos().add(auto);
            session.update(user);
            tx1.commit();
        }
    }
}
