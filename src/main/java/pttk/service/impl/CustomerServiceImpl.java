package pttk.service.impl;

import pttk.logic.application.userDAO.UserDAO;
import pttk.logic.application.userDAO.impl.UserDAOImpl;
import pttk.model.user.Account;
import pttk.model.user.User;
import pttk.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private final UserDAO userDAO = new UserDAOImpl();

    @Override
    public User findByUserNameAndPassword(String username, String password) {
        Account account = new Account(username, password);
        return userDAO.findByAccount(account);
    }

    @Override
    public Boolean createNewCustomer(User customer) {
        return userDAO.create(customer);
    }

    @Override
    public Boolean updateCustomer(User customer) {
        return userDAO.update(customer);
    }

}
