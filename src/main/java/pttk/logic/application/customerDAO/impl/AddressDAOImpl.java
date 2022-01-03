package pttk.logic.application.customerDAO.impl;

import pttk.logic.application.BaseDAOImpl;
import pttk.logic.application.customerDAO.AddressDAO;
import pttk.model.customer.Address;
import pttk.util.impl.AddressMapper;

import java.util.List;

public class AddressDAOImpl extends BaseDAOImpl implements AddressDAO {

    @Override
    public Address findAddressByCustomerId(int customerId) {
        String sql = "SELECT * FROM address WHERE CustomerID = ?";
        List<Address> addressList = query(sql, new AddressMapper(), customerId);
        System.out.println("pttk.dao.customer.impl.AddressDAOImpl.findAddressByCustomerId()-------" + addressList.toString());
        return addressList.isEmpty() ? null : addressList.get(0);
    }
}
