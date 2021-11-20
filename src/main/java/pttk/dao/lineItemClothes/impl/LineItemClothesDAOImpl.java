package pttk.dao.lineItemClothes.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.lineItemClothes.LineItemClothesDAO;
import pttk.model.clothes.LineItemClothes;

public class LineItemClothesDAOImpl extends BaseDAOImpl<LineItemClothes> implements LineItemClothesDAO {

    @Override
    public Long create(int cardId, int itemClothesId, int quantity) {
        String sql = "INSERT INTO LineItemBook (cardID, itemBookId, quantityB) VALUES (?, ?, ?)";
        Long ans = insert(sql, cardId, itemClothesId, quantity);
        return ans;
    }
}
