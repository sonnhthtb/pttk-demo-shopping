package vn.grooo.util.impl;

import vn.grooo.entity.UserEntity;
import vn.grooo.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserEntity> {
    @Override
    public UserEntity mapRow(ResultSet resultSet) {
        try {
            UserEntity user = new UserEntity();
            user.setId(resultSet.getLong("id"));
            user.setUsername(resultSet.getString("username"));
            user.setFullName(resultSet.getString("fullname"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(resultSet.getString("role"));
            user.setIsDeleted(resultSet.getBoolean("is_deleted"));
            return user;
        } catch (SQLException e) {
            return null;
        }
    }
}
