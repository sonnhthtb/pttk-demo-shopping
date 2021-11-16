package pttk.dao.cart;

import pttk.dao.BaseDAO;
import pttk.entity.order.Cart;

public interface CartDAO extends BaseDAO {
    Cart getCartByCustomerId(int customerId);
}
