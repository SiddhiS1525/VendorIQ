package services;

import dao.UserDAO;
import model.User;

public class LoginService {

    private UserDAO userDAO = new UserDAO();

    public User login(String email, String password) {

        return userDAO.login(email, password);

    }

}
