package pttk.logic.application.userDAO.impl;

import pttk.logic.application.BaseDAOImpl;
import pttk.logic.application.userDAO.AddressDAO;
import pttk.model.user.Address;
import pttk.util.impl.AddressMapper;

import java.util.List;

public class AddressDAOImpl extends BaseDAOImpl implements AddressDAO {

    @Override
    public Address findAddressByCustomerId(int customerId) {
        String sql = "SELECT * FROM address WHERE UserID = ?";
        List<Address> addressList = query(sql, new AddressMapper(), customerId);
        System.out.println("pttk.dao.customer.impl.AddressDAOImpl.findAddressByCustomerId()-------" + addressList.toString());
        return addressList.isEmpty() ? null : addressList.get(0);
    }
}
