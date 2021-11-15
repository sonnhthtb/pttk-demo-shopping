package pttk.service.impl;

import pttk.dao.customer.CustomerDAO;
import pttk.dao.customer.impl.CustomerDAOImpl;
import pttk.entity.Account;
import pttk.entity.Customer;
import pttk.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO customerDAO = new CustomerDAOImpl();
    @Override
    public Customer findByUserNameAndPassword(String username, String password) {
        Account account = new Account(username, password);
        return customerDAO.findByAccount(account);
    }
}