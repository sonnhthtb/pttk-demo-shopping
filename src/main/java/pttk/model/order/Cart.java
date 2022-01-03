package pttk.model.order;

import pttk.model.book.LineItemBook;
import pttk.model.customer.Customer;

import java.util.List;

public class Cart {
    private Integer id;
    private String cartStatus;
    private Float totalPrice;
    private List<LineItemBook> lineItemBooks;
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(String cartStatus) {
        this.cartStatus = cartStatus;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<LineItemBook> getLineItemBooks() {
        return lineItemBooks;
    }

    public void setLineItemBooks(List<LineItemBook> lineItemBooks) {
        this.lineItemBooks = lineItemBooks;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
