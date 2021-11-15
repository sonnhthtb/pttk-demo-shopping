package pttk.dao.customer;

import pttk.dao.BaseDAO;
import pttk.entity.Account;
import pttk.util.impl.AccountMapper;

import java.util.List;

public interface AccountDAO extends BaseDAO {
    Account findAccountByUserNameAndPassword(String username, String password);
    Account findAccountByCustomerId(int customerId);
}
