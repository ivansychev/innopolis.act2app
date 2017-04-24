package model.dao.interfaces;

import model.pojo.User;

/**
 * Created by ivans on 20/04/2017.
 */
public interface UserDAO extends DAO<User, Integer>{
    User findUserByLoginAndPassword(String login, String password);
}
