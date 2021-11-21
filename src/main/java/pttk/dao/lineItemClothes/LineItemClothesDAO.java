package pttk.dao.lineItemClothes;

import pttk.dao.BaseDAO;
import pttk.dao.BaseDAOImpl;
import pttk.model.clothes.LineItemClothes;

import java.util.List;

public interface LineItemClothesDAO extends BaseDAO<LineItemClothes> {
    Long create(int cartId, int itemClothesId, int quantityC);
    List<LineItemClothes> findByCartId(int cartId);
    void updateQuantity(int quantity, int id);
    void deleteLineItemClothes(int id);

}
