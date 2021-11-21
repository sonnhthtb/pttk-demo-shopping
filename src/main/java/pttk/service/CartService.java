package pttk.service;

import pttk.model.book.ItemBook;
import pttk.model.order.Cart;

public interface CartService {
    Cart getCartByOrderId(int orderId);
    Cart getCartByCustomerId(int customerId);
    Boolean addBookToCart(ItemBook itemBook);
    Boolean addClothesToCart(ItemBook itemBook);
    Long create(int customerId);
}
