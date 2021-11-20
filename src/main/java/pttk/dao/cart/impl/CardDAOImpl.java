package pttk.dao.cart.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.cart.CartDAO;
import pttk.model.book.LineItemBook;
import pttk.model.clothes.LineItemClothes;
import pttk.model.electronic.LineItemElectronic;
import pttk.model.order.Cart;
import pttk.model.shoes.LineItemShoes;
import pttk.util.impl.*;

import java.util.List;

public class CardDAOImpl extends BaseDAOImpl implements CartDAO {

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

    @Override
    public Cart getCartByCustomerId(int customerId) {
        String sql = "SELECT * FROM cart WHERE CustomerId = ? and CartStatus = ?";
        List<Cart> cartList = query(sql, new CartMapper(), customerId, "active");
        return cartList.isEmpty() ? null : cartList.get(0);
    }

    @Override
    public Long create(int customerId) {
        String sql = "insert into cart(customerId, cartStatus, totalPrice) value (?,?,?)";
        Long ans = insert(sql, customerId,"active",0);
        return ans;
    }
}
