package vn.grooo.dao.customer;

import vn.grooo.dao.BaseDAO;
import vn.grooo.entity.Account;
import vn.grooo.entity.Customer;

public interface CustomerDAO extends BaseDAO {
    Customer findByAccount(Account account);
}
