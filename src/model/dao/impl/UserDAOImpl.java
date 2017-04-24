package model.dao.impl;

import model.ConnectionPool;
import model.dao.interfaces.UserDAO;
import model.pojo.User;
import org.apache.log4j.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ivans on 20/04/2017.
 */
public class UserDAOImpl implements UserDAO {

    private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

    public Collection<User> getAll() {
        throw new NotImplementedException();
    }

    public User save(User entity) {
        return null;
    }

    public User getById(Integer id) {
        throw new NotImplementedException();
    }

    public Integer insert(User entity){
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("INSERT INTO users(" +
                             " user_rights, user_firstname, user_surname, user_email, user_password)" +
                             " VALUES (?, ?, ?, ?, ?)")) {
            statement.setString(1, entity.getUserRights());
            statement.setString(2, entity.getUserFirstname());
            statement.setString(3, entity.getUserSurname());
            statement.setString(4, entity.getUserEmail());
            statement.setString(5, entity.getUserPassword());
            statement.addBatch();
            statement.executeBatch();
            logger.debug("new user: " + entity);
        } catch (SQLException e) {
            logger.error(e);
        }
        return 1;
    }

    public int update(User entity) {
        throw new NotImplementedException();
    }

    public int delete(User entity) {
        throw new NotImplementedException();
    }

    public User findUserByLoginAndPassword(String login, String password) {
        User user = null;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement( "SELECT * FROM public.users WHERE user_email = ? AND user_password = ?")) {

            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = createEntity(resultSet);
            }

            logger.debug("user " + user);
        } catch (SQLException e) {
            logger.error(e);
        }

        return user;
    }

    private User createEntity(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getInt("user_id"),
                resultSet.getString("user_rights"),
                resultSet.getString("user_firstname"),
                resultSet.getString("user_surname"),
                resultSet.getString("user_email"),
                resultSet.getString("user_password"));
    }
}
