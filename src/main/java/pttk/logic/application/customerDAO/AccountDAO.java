package pttk.logic.application.customerDAO;

import pttk.logic.application.BaseDAO;
import pttk.model.customer.Account;

public interface AccountDAO extends BaseDAO {
    Account findAccountByUserNameAndPassword(String username, String password);

    Account findAccountByCustomerId(int customerId);

    Account findById(Long id);
}
