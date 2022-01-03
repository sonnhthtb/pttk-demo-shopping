package pttk.logic.application.customerDAO;

import pttk.logic.application.BaseDAO;
import pttk.model.customer.FullName;

public interface FullNameDAO extends BaseDAO {
    FullName findFullNameByCustomerID(int customerId);
}
