package pttk.service;

import pttk.model.customer.Customer;

public interface CustomerService {
    Customer findByUserNameAndPassword(String username, String password);
}
