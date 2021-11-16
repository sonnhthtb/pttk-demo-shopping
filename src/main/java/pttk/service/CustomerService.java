package pttk.service;

import pttk.entity.customer.Customer;

public interface CustomerService {
    Customer findByUserNameAndPassword(String username, String password);
}
