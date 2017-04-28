package services;

import model.pojo.User;

/**
 * Created by ivans on 20/04/2017.
 */
public interface UserService {
    User auth(String login, String password);
    void signup(User user);
    String getUserPass(String email);
}
