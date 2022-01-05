package pttk.model.order;

import pttk.model.book.LineItemBook;
import pttk.model.user.User;

import java.util.List;

public class Cart {
    private Integer id;
    private String status;
    private Float totalPrice;
    private List<LineItemBook> lineItemBooks;
    private User customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }
}
