package pttk.logic.application.customerDAO;

import pttk.logic.application.BaseDAO;
import pttk.model.customer.Address;

public interface AddressDAO extends BaseDAO {
    Address findAddressByCustomerId(int customerId);
}
