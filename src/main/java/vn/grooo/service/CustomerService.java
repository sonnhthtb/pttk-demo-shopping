package vn.grooo.service;

import vn.grooo.entity.Account;
import vn.grooo.entity.Customer;

public interface CustomerService {
    Customer findByUserNameAndPassword(String username, String password);
}
