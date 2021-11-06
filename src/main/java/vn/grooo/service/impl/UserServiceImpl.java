package vn.grooo.service.impl;

import vn.grooo.dao.UserDAO;
import vn.grooo.dao.impl.UserDAOImpl;
import vn.grooo.entity.UserEntity;
import vn.grooo.service.UserService;

import java.sql.Timestamp;

public class UserServiceImpl implements UserService {

    private final UserDAO userDAO = new UserDAOImpl();

    @Override
    public UserEntity findByUserNameAndPassword(String username, String password) {
        return userDAO.findByUsernameAndPassword(username,password);
    }

    @Override
    public UserEntity findByUserName(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public UserEntity save(String username, String password, String fullName) {
        return userDAO.save(username, password, fullName);
    }

    @Override
    public void update(UserEntity user) {
        user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        userDAO.update(user);
    }
}
