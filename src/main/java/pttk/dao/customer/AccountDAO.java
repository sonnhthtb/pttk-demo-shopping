package pttk.dao.customer;

import pttk.dao.BaseDAO;
import pttk.entity.customer.Account;

public interface AccountDAO extends BaseDAO {
    Account findAccountByUserNameAndPassword(String username, String password);
    Account findAccountByCustomerId(int customerId);
}
