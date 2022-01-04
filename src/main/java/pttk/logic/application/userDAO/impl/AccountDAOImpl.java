package pttk.logic.application.userDAO.impl;

import pttk.logic.application.BaseDAOImpl;
import pttk.logic.application.userDAO.AccountDAO;
import pttk.model.user.Account;
import pttk.util.impl.AccountMapper;

import java.util.List;

public class AccountDAOImpl extends BaseDAOImpl implements AccountDAO {

    @Override
    public Account findAccountByUserNameAndPassword(String username, String password) {
        String sql = "SELECT * FROM account WHERE username = ? AND password = ?";
        List<Account> accountList = query(sql, new AccountMapper(), username, password);
        return accountList.isEmpty() ? null : accountList.get(0);
    }

    @Override
    public Account findAccountByCustomerId(int customerId) {
        String sql = "SELECT * FROM account WHERE UserID  = ?";
        List<Account> accountList = query(sql, new AccountMapper(), customerId);
        return accountList.isEmpty() ? null : accountList.get(0);
    }

    @Override
    public Account findById(Long id) {
        String sql = "SELECT * FROM `order` WHERE id = ?";
        List<Account> accounts = query(sql, new AccountMapper(), id);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

}
