package vn.grooo.dao.customer;

import vn.grooo.dao.BaseDAO;
import vn.grooo.entity.Account;
import vn.grooo.entity.Cart;
import vn.grooo.entity.Customer;
import vn.grooo.entity.Order;

import java.util.List;

public interface CustomerDAO extends BaseDAO {
    Customer findByAccount(Account account);
    Customer findCustomerByCart(Cart Cart);
}
