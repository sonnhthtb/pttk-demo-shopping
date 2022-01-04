package pttk.logic.application.userDAO;

import pttk.logic.application.BaseDAO;
import pttk.model.user.FullName;

public interface FullNameDAO extends BaseDAO {
    FullName findFullNameByCustomerID(int customerId);
}
