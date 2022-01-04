package pttk.service;

import pttk.model.user.User;

public interface CustomerService {
    User findByUserNameAndPassword(String username, String password);

    Boolean createNewCustomer(User customer);

    Boolean updateCustomer(User customer);
}
