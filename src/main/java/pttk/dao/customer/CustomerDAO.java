package pttk.dao.customer;

import pttk.dao.BaseDAO;
import pttk.entity.Account;
import pttk.entity.Customer;
import pttk.entity.Cart;

public interface CustomerDAO extends BaseDAO {
    Customer findByAccount(Account account);
    Customer findCustomerByCart(Cart Cart);
}
