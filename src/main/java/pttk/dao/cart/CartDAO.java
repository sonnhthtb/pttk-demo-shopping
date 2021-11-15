package pttk.dao.cart;

import pttk.dao.BaseDAO;
import pttk.entity.Order;
import pttk.entity.Cart;

public interface CartDAO extends BaseDAO {
    Cart getCartByOrderId(Order order);
}
