package pttk.dao.cart;

import pttk.dao.BaseDAO;
import pttk.model.order.Cart;

public interface CartDAO extends BaseDAO {
    Cart getCartByCustomerId(int customerId);
    Cart findById(int id);
    Long create(int customerId);
    Cart update(Cart cart);
}
