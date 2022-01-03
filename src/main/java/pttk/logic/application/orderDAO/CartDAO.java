package pttk.logic.application.orderDAO;

import pttk.logic.application.BaseDAO;
import pttk.model.order.Cart;

public interface CartDAO extends BaseDAO {
    Cart getCartByCustomerId(int customerId, String status);

    Cart findById(int id);

    Long create(int customerId);

    Cart update(Cart cart);
}
