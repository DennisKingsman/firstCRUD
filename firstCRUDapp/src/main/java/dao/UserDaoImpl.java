package dao;

import models.Auto;
import models.User;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserDaoImpl implements UserDao{
// jPoint 2017 alexei shipilev
    @Override
    public User findByID(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        User user = session.get(User.class, id);
        tx1.commit();
        session.getSessionFactory().close();
        return user;

       // return (User) HibernateSessionFactoryUtil.getSessionFactory().openStatelessSession().get(User.class, id);

    }

    @Override
    public void save(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.getSessionFactory().close();
    }

    @Override
    public void update(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.getSessionFactory().close();
    }

    @Override
    public void delete(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.getSessionFactory().close();
    }

    @Override
    public Auto findAutoByID(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Auto auto = session.get(Auto.class, id);
        tx1.commit();
        session.getSessionFactory().close();
        return auto;

        //return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);
    }

    @Override
    public List<User> findAll(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<User> users = session.createQuery("From User").list();
        tx1.commit();
        session.getSessionFactory().close();
        return users;
    }
}
