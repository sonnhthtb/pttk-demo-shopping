package vn.grooo.dao;

import vn.grooo.entity.UserEntity;

public interface UserDAO extends BaseDAO<UserEntity>{
    UserEntity findByUsernameAndPassword(String username, String password);
    UserEntity findByUsername(String username);
    UserEntity findById(Long id);
    UserEntity save(String username, String password, String fullname);
    void update(UserEntity user);
}
