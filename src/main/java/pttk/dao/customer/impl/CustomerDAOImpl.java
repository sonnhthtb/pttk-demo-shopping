package pttk.dao.customer.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.customer.AccountDAO;
import pttk.dao.customer.AddressDAO;
import pttk.dao.customer.CustomerDAO;
import pttk.dao.customer.FullNameDAO;
import pttk.entity.customer.Account;
import pttk.entity.customer.Customer;
import pttk.entity.order.Cart;
import pttk.util.impl.CustomerMapper;

import java.util.List;

public class CustomerDAOImpl extends BaseDAOImpl implements CustomerDAO{

    private final AccountDAO accountDAO = new AccountDAOImpl();
    private final AddressDAO addressDAO = new AddressDAOImpl();
    private final FullNameDAO fullNameDAO = new FullNameDAOImpl();

    @Override
    public Customer findByAccount(Account account) {
        account = accountDAO.findAccountByUserNameAndPassword(account.getUsername(), account.getPassword());
        if(account != null) {
            String sql = "SELECT c.* FROM Customer c LEFT JOIN Account a ON c.id = a.CustomerID WHERE a.id = ?";
            List<Customer> customers = query(sql, new CustomerMapper(), account.getId());
            Customer customer = customers.isEmpty() ? null : customers.get(0);
            if (customer != null) {
                int customerId = customer.getId();
                customer.setAccount(account);
                customer.setAddress(addressDAO.findAddressByCustomerId(customerId));
                customer.setFullName(fullNameDAO.findFullNameByCustomerID(customerId));
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
            customer.setAccount(accountDAO.findAccountByCustomerId(customerId));
            customer.setAddress(addressDAO.findAddressByCustomerId(customerId));
            customer.setFullName(fullNameDAO.findFullNameByCustomerID(customerId));
        }
        return customer;
    }
}
