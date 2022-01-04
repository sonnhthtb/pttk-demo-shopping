package pttk.model.order;

import pttk.model.user.User;

import java.util.Date;

public class Order {
    private Integer id;
    private Date date;
    private String status;
    private User customer;
    private Shipment shipment;
    private Payment payment;
    private Cart cart;

    public Order(Date date, String status, User customer, Shipment shipment, Payment payment, Cart cart) {
        this.date = date;
        this.status = status;
        this.customer = customer;
        this.shipment = shipment;
        this.payment = payment;
        this.cart = cart;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
