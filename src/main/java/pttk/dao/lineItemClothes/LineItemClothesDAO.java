package pttk.dao.lineItemClothes;

import pttk.dao.BaseDAO;
import pttk.dao.BaseDAOImpl;
import pttk.model.clothes.LineItemClothes;

public interface LineItemClothesDAO extends BaseDAO<LineItemClothes> {
    Long create(int cardId, int itemBookId, int quantityB);
}
