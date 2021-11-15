package pttk.dao.customer;

import pttk.dao.BaseDAO;
import pttk.entity.Account;
import pttk.entity.FullName;

public interface FullNameDAO extends BaseDAO {
    FullName findFullNameByCustomerID(int customerId);
}
