package vn.grooo.dao.cart;

import vn.grooo.dao.BaseDAO;
import vn.grooo.entity.Cart;
import vn.grooo.entity.Order;

public interface CartDAO extends BaseDAO {
    Cart getCartByOrderId(Order order);
}
