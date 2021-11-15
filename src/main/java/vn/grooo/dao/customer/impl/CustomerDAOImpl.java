package vn.grooo.dao.customer.impl;

import vn.grooo.dao.BaseDAOImpl;
import vn.grooo.dao.customer.CustomerDAO;
import vn.grooo.entity.*;
import vn.grooo.util.impl.AccountMapper;
import vn.grooo.util.impl.AddressMapper;
import vn.grooo.util.impl.CustomerMapper;
import vn.grooo.util.impl.FullNameMapper;

import java.util.List;

public class CustomerDAOImpl extends BaseDAOImpl implements CustomerDAO{

    @Override
    public Customer findByAccount(Account account) {
        account = findAccountByUserNameAndPassword(account.getUsername(), account.getPassword());
        if(account != null) {
            String sql = "SELECT c.* FROM Customer c LEFT JOIN Account a ON c.id = a.CustomerID WHERE a.id = ?";
            List<Customer> customers = query(sql, new CustomerMapper(), account.getId());
            Customer customer = customers.isEmpty() ? null : customers.get(0);
            if (customer != null) {
                int customerId = customer.getId();
                customer.setAccount(account);
                customer.setAddress(findAddressByCustomerId(customerId));
                customer.setFullName(findFullNameByCustomerID(customerId));
            }
            return customer;
        }
        return null;
    }

    @Override
    public Customer findCustomerByCart(Cart Cart) {
        String sql = "SELECT * FROM Customer, Cart " +
                "Where Customer.ID = Cart.CustomerID" +
                "and Card.ID = ?";
        List<Customer> customers = query(sql, new CustomerMapper(), Cart.getId());
        Customer customer = customers.isEmpty() ? null : customers.get(0);
        if(customer != null) {
            int customerId = customer.getId();
            customer.setAccount(findAccountByCustomerId(customerId));
            customer.setAddress(findAddressByCustomerId(customerId));
            customer.setFullName(findFullNameByCustomerID(customerId));
        }
        return customer;
    }

    private Account findAccountByCustomerId(int customerId){
        String sql = "SELECT * FROM Account WHERE CustomerID = ?";
        List<Account> accountList =  query(sql, new AccountMapper(), customerId);
        return accountList.isEmpty() ? null : accountList.get(0);
    }

    private Account findAccountByUserNameAndPassword(String username, String password) {
        String sql = "SELECT * FROM Account WHERE username = ? AND password = ?";
        List<Account> accountList =  query(sql, new AccountMapper() ,username, password);
        return accountList.isEmpty() ? null : accountList.get(0);
    }

    private Address findAddressByCustomerId(int customerId) {
        String sql = "SELECT * FROM Address WHERE CustomerID = ?";
        List<Address> addressList =  query(sql, new AddressMapper() , customerId);
        return addressList.isEmpty() ? null : addressList.get(0);
    }

    private FullName findFullNameByCustomerID(int customerId) {
        String sql = "SELECT * FROM fullname WHERE CustomerID = ?";
        List<FullName> fullNameList =  query(sql, new FullNameMapper() , customerId);
        return fullNameList.isEmpty() ? null : fullNameList.get(0);
    }
}
