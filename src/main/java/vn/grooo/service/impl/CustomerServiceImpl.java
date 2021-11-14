package vn.grooo.service.impl;

import vn.grooo.dao.customer.CustomerDAO;
import vn.grooo.dao.customer.impl.CustomerDAOImpl;
import vn.grooo.entity.Account;
import vn.grooo.entity.Customer;
import vn.grooo.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO customerDAO = new CustomerDAOImpl();
    @Override
    public Customer findByUserNameAndPassword(String username, String password) {
        Account account = new Account(username, password);
        return customerDAO.findByAccount(account);
    }
}
