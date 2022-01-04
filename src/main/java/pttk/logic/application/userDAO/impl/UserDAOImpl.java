package pttk.logic.application.userDAO.impl;

import pttk.logic.application.BaseDAOImpl;
import pttk.logic.application.userDAO.AccountDAO;
import pttk.logic.application.userDAO.AddressDAO;
import pttk.logic.application.userDAO.UserDAO;
import pttk.logic.application.userDAO.FullNameDAO;
import pttk.model.user.Account;
import pttk.model.user.Address;
import pttk.model.user.User;
import pttk.model.user.FullName;
import pttk.model.order.Cart;
import pttk.util.impl.CustomerMapper;

import java.util.List;

public class UserDAOImpl extends BaseDAOImpl implements UserDAO {
    private final AccountDAO accountDAO = new AccountDAOImpl();
    private final AddressDAO addressDAO = new AddressDAOImpl();
    private final FullNameDAO fullNameDAO = new FullNameDAOImpl();

    @Override
    public User findByAccount(Account account) {
        account = accountDAO.findAccountByUserNameAndPassword(account.getUsername(), account.getPassword());
        if (account != null) {
            String sql = "SELECT c.* FROM User c LEFT JOIN Account a ON c.id = a.UserID WHERE a.id = ?";
            List<User> customers = query(sql, new CustomerMapper(), account.getId());
            User customer = customers.isEmpty() ? null : customers.get(0);
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
    public User findCustomerByCart(Cart Cart) {
        String sql = "SELECT * FROM User, Cart " +
                "Where User.ID = Cart.UserID" +
                "and Card.ID = ?";
        List<User> customers = query(sql, new CustomerMapper(), Cart.getId());
        User customer = customers.isEmpty() ? null : customers.get(0);
        if (customer != null) {
            int customerId = customer.getId();
            customer.setAccount(accountDAO.findAccountByCustomerId(customerId));
            customer.setAddress(addressDAO.findAddressByCustomerId(customerId));
            customer.setFullName(fullNameDAO.findFullNameByCustomerID(customerId));
        }
        return customer;
    }

    @Override
    public User findById(int id) {
        String sql = "SELECT * FROM User WHERE id = ?";
        List<User> customers = query(sql, new CustomerMapper(), id);
        User customer = customers.isEmpty() ? null : customers.get(0);
        if (customer != null) {
            int customerId = customer.getId();
            customer.setAccount(accountDAO.findAccountByCustomerId(customerId));
            customer.setAddress(addressDAO.findAddressByCustomerId(customerId));
            customer.setFullName(fullNameDAO.findFullNameByCustomerID(customerId));
        }
        return customer;
    }

    @Override
    public Boolean create(User customer) {
        try {
            String sqlCustomer = "INSERT INTO `user` (Role) VALUES (?)";
            Long idCustomer = insert(sqlCustomer, "USER");
            Account account = customer.getAccount();
            String sqlAccount = "INSERT INTO `account` (Username, Password, UserID) VALUES ( ?, ?,?)";
            long idAccount = accountDAO.insert(sqlAccount, account.getUsername(), account.getPassword(), idCustomer);
            FullName fullname = customer.getFullName();
            String sqlFullname = "INSERT INTO `fullname` (FirstName, MiddleName, LastName,UserID) VALUES ( ?, ?,?,?)";
            long idFullname = fullNameDAO.insert(sqlFullname, fullname.getFirstName(), fullname.getMiddleName(), fullname.getLastName(), idCustomer);
            String sqlAddress = "INSERT INTO `address` (Number, Street, District,City,UserID) VALUES ( ?, ?,?,?,?)";
            long idAdress = addressDAO.insert(sqlAddress, 0, "", "", "", idCustomer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(User customer) {
        try {
            int idCustomer = customer.getId();
            //update password
            Account account = customer.getAccount();
            String sqlAccount = "UPDATE `account` SET Password =? WHERE UserID = ? ";
            accountDAO.update(sqlAccount, account.getPassword(), idCustomer);
            //update fullname

            FullName fullname = customer.getFullName();
            if (fullname.isValid() == true) {
                String sqlFullName = "UPDATE `fullname` SET FirstName =?,MiddleName=?,LastName=? WHERE UserID = ? ";
                fullNameDAO.update(sqlFullName, fullname.getFirstName(), fullname.getMiddleName(), fullname.getLastName(), idCustomer);
            }


            //update
            Address address = customer.getAddress();
            String sqlAddress = "UPDATE `address` SET Number =?,Street=?,District=?,City=? WHERE UserID = ? ";
            fullNameDAO.update(sqlAddress, address.getNumberHouse(), address.getStreet(), address.getDistrict(), address.getCity(), idCustomer);
            System.out.println("pttk.dao.customer.impl.CustomerDAOImpl.update()-------------------");
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
