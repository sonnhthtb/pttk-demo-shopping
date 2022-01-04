package pttk.logic.application.userDAO;

import pttk.logic.application.BaseDAO;
import pttk.model.user.Account;
import pttk.model.user.User;
import pttk.model.order.Cart;

public interface UserDAO extends BaseDAO {
    User findByAccount(Account account);

    User findCustomerByCart(Cart Cart);

    User findById(int id);

    Boolean create(User customer);

    Boolean update(User customer);
}
