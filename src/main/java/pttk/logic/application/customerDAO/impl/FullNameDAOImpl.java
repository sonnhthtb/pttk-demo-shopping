package pttk.logic.application.customerDAO.impl;

import pttk.logic.application.BaseDAOImpl;
import pttk.logic.application.customerDAO.FullNameDAO;
import pttk.model.customer.FullName;
import pttk.util.impl.FullNameMapper;

import java.util.List;

public class FullNameDAOImpl extends BaseDAOImpl implements FullNameDAO {

    @Override
    public FullName findFullNameByCustomerID(int customerId) {
        String sql = "SELECT * FROM fullname WHERE CustomerID = ?";
        List<FullName> fullNameList = query(sql, new FullNameMapper(), customerId);
        return fullNameList.isEmpty() ? null : fullNameList.get(0);
    }
}
