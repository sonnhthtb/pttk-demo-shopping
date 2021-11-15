package pttk.service;

import pttk.entity.Customer;

public interface CustomerService {
    Customer findByUserNameAndPassword(String username, String password);
}
