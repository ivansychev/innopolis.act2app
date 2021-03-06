package services;

import model.dao.impl.UserDAOImpl;
import model.dao.interfaces.UserDAO;
import model.pojo.User;
import org.apache.log4j.Logger;

/**
 * Created by ivans on 20/04/2017.
 */
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    private UserDAO userDAO;

    public User auth(String login, String password) {
        User user = userDAO.findUserByLoginAndPassword(login, password);
        logger.debug("user: " + user);
        return user;
    }
    public void signup(User user)
    {
        userDAO.insert(user);
        logger.debug("new user: " + user);
    }

    @Override
    public String getUserPass(String email) {
        return "pass";
    }
}
