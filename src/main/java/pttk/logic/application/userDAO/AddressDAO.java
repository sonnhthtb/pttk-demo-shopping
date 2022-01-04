package pttk.logic.application.userDAO;

import pttk.logic.application.BaseDAO;
import pttk.model.user.Address;

public interface AddressDAO extends BaseDAO {
    Address findAddressByCustomerId(int customerId);
}
