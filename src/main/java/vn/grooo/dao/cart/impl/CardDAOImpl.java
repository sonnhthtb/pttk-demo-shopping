package vn.grooo.dao.cart.impl;

import vn.grooo.dao.BaseDAOImpl;
import vn.grooo.dao.cart.CartDAO;
import vn.grooo.dao.customer.CustomerDAO;
import vn.grooo.entity.*;
import vn.grooo.util.impl.*;

import java.util.List;

public class CardDAOImpl extends BaseDAOImpl implements CartDAO {

    private final CustomerDAO customerDAO;

    public CardDAOImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Cart getCartByOrderId(Order order) {
        String sql = "SELECT * FROM Cart where OrderID = ?";
        List<Cart> carts = query(sql, new CartMapper(), order.getId());
        Cart cart = carts.isEmpty() ? null : carts.get(0);
        if(cart != null){
            cart.setCustomer(customerDAO.findCustomerByCart(cart));
            cart.setLineItemBooks(getListLineItemBookByCartID(cart.getId()));
            cart.setLineItemClothes(getListLineItemClothesByCartID(cart.getId()));
            cart.setLineItemElectronics(getListLineItemElectronicByCartID(cart.getId()));
            cart.setLineItemShoes(getListLineItemShoesByCartID(cart.getId()));
        }
        return cart;
    }

    private List<LineItemBook> getListLineItemBookByCartID(int cartId){
        String sql = "SELECT * FROM lineitembook, cart " +
                "where cart.ID = lineitembook.CartID " +
                "and cart.ID = ?";
        List<LineItemBook> lineItemBooks = query(sql, new LineItemBookMapper(), cartId);
        return lineItemBooks;
    }

    private List<LineItemElectronic> getListLineItemElectronicByCartID(int cartId){
        String sql = "SELECT * FROM lineitemelectronic, cart " +
                "where cart.ID = lineitemelectronick.CartID " +
                "and cart.ID = ?";
        List<LineItemElectronic> lineItemElectronics = query(sql, new LineItemElectronicMapper(), cartId);
        return lineItemElectronics;
    }

    private List<LineItemClothes> getListLineItemClothesByCartID(int cartId){
        String sql = "SELECT * FROM lineitemclothes, cart " +
                "where cart.ID = lineitemclothes.CartID " +
                "and cart.ID = ?";
        List<LineItemClothes> lineItemClothes = query(sql, new LineItemClothesMapper(), cartId);
        return lineItemClothes;
    }

    private List<LineItemShoes> getListLineItemShoesByCartID(int cartId){
        String sql = "SELECT * FROM lineitemshoes, cart " +
                "where cart.ID = lineitemshoes.CartID " +
                "and cart.ID = ?";
        List<LineItemShoes> lineItemShoes = query(sql, new LineItemShoesMapper(), cartId);
        return lineItemShoes;
    }

}
