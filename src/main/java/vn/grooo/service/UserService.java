package vn.grooo.service;

import vn.grooo.entity.UserEntity;

public interface UserService {
    UserEntity findByUserNameAndPassword(String username, String password);
    UserEntity findByUserName(String username);
    UserEntity save(String username, String password, String fullName);
    void update(UserEntity user);
}
