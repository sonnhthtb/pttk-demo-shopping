package pttk.logic.application.userDAO;

import pttk.logic.application.BaseDAO;
import pttk.model.user.Account;

public interface AccountDAO extends BaseDAO {
    Account findAccountByUserNameAndPassword(String username, String password);

    Account findAccountByCustomerId(int customerId);

    Account findById(Long id);
}
