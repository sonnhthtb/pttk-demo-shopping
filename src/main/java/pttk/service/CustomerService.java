package pttk.service;

import pttk.entity.Account;
import pttk.entity.Customer;
import pttk.entity.FullName;

public interface CustomerService {
    Customer findByUserNameAndPassword(String username, String password);
    Boolean createNewCustomer(Customer customer);
}
