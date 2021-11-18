package pttk.dao.customer.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.customer.AddressDAO;
import pttk.model.customer.Address;
import pttk.util.impl.AddressMapper;

import java.util.List;

public class AddressDAOImpl extends BaseDAOImpl implements AddressDAO {

    @Override
    public Address findAddressByCustomerId(int customerId) {
        String sql = "SELECT * FROM Address WHERE CustomerID = ?";
        List<Address> addressList =  query(sql, new AddressMapper() , customerId);
        return addressList.isEmpty() ? null : addressList.get(0);
    }
}
