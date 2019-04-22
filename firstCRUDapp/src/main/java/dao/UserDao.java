package dao;

import models.Auto;
import models.User;

import java.util.List;

public interface UserDao {

    User findByID(int id);

    void save(User user);

    void update(User user);

    void delete(User user);

    Auto findAutoByID(int id);

    List findAll();

    void addAuto(User user, Auto auto);
}
