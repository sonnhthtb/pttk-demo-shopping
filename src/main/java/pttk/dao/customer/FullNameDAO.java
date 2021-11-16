package pttk.dao.customer;

import pttk.dao.BaseDAO;
import pttk.entity.customer.FullName;

public interface FullNameDAO extends BaseDAO {
    FullName findFullNameByCustomerID(int customerId);
}
