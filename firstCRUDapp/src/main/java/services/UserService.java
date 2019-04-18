package services;

import dao.UserDao;
import dao.UserDaoImpl;
import models.Auto;
import models.User;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDaoImpl();

    public UserService(){
    }

    public User findUser(int id){
        return userDao.findByID(id);
    }

    public void saveUser(User user){
        userDao.save(user);
    }

    public void deleteUser(User user){
        userDao.delete(user);
    }

    public void updateUser(User user){
        userDao.update(user);
    }

    public List<User> findAllUsers(){
        return userDao.findAll();
    }

    public Auto findAutoByID(int id){
        return userDao.findAutoByID(id);
    }
}
