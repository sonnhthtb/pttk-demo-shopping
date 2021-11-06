package vn.grooo.dao.impl;

import vn.grooo.dao.UserDAO;
import vn.grooo.entity.UserEntity;
import vn.grooo.util.impl.UserMapper;

import java.util.List;

public class UserDAOImpl extends BaseDAOImpl<UserEntity> implements UserDAO {
    @Override
    public UserEntity findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM user WHERE username = ? AND password = ? AND is_deleted = 0";
        List<UserEntity> userEntities = query(sql, new UserMapper(), username, password);
        return userEntities.isEmpty() ? null : userEntities.get(0);
    }

    @Override
    public UserEntity findByUsername(String username) {
        String sql = "SELECT * FROM user WHERE username = ? ";
        List<UserEntity> userEntities = query(sql, new UserMapper(), username);
        return userEntities.isEmpty() ? null : userEntities.get(0);
    }

    public UserEntity findById(Long id) {
        String sql = "SELECT * FROM user WHERE id = ? ";
        List<UserEntity> userEntities = query(sql, new UserMapper(), id);
        return userEntities.isEmpty() ? null : userEntities.get(0);
    }

    @Override
    public UserEntity save(String username, String password, String fullName) {
        String sql = "INSERT INTO user (username, password, fullname) VALUES (?, ?, ?)";
        Long id = insert(sql, username, password, fullName);
        return findById(id);
    }

    @Override
    public void update(UserEntity user) {
        String sql = "UPDATE `User` SET password = ?, updated_at = ? WHERE id = ?";
        update(sql, user.getPassword(), user.getUpdatedAt(), user.getId());
    }
}
