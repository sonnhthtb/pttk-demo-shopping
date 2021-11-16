package pttk.dao.customer;

import pttk.dao.BaseDAO;
import pttk.entity.customer.Account;
import pttk.entity.customer.Customer;
import pttk.entity.order.Cart;

public interface CustomerDAO extends BaseDAO {
    Customer findByAccount(Account account);
    Customer findCustomerByCart(Cart Cart);
}
