package pttk.model.user;

import pttk.model.order.Cart;


public class User {
    private Integer id;
    private Account account;
    private Address address;
    private FullName fullName;
    private String role;
    private Cart cart;

    public User(Account account, Address address, FullName fullName, String role, Cart cart) {
        this.account = account;
        this.address = address;
        this.fullName = fullName;
        this.role = role;
        this.cart = cart;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
