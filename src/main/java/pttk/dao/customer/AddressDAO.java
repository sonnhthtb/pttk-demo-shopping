package pttk.dao.customer;

import pttk.dao.BaseDAO;
import pttk.entity.Account;
import pttk.entity.Address;

public interface AddressDAO extends BaseDAO {
    Address findAddressByCustomerId(int customerId);
}
