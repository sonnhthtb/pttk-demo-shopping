package pttk.dao.clothes.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.clothes.LineItemClothesDAO;
import pttk.model.clothes.LineItemClothes;
import pttk.util.impl.LineItemClothesMapper;

import java.util.List;

public class LineItemClothesDAOImpl extends BaseDAOImpl<LineItemClothes> implements LineItemClothesDAO {

    @Override
    public Long create(int cartId, int itemClothesId, int quantity) {
        String sql = "INSERT INTO LineItemClothes (cartID, itemClothesId, quantityC) VALUES (?, ?, ?)";
        Long ans = insert(sql, cartId, itemClothesId, quantity);
        return ans;
    }

    @Override
    public List<LineItemClothes> findByCartId(int cartId) {
        String sql = "select * from lineItemClothes where cartId = ?";
        List<LineItemClothes> list = query(sql, new LineItemClothesMapper(), cartId);
        return list;
    }

    @Override
    public void updateQuantity(int quantity, int id) {
        String sql = "update LineItemClothes set quantityC = ? where id = ?";
        update(sql,quantity, id);
    }

    @Override
    public void deleteLineItemClothes(int id) {
        String sql = "delete from lineItemClothes where id = ?";
        update(sql, id);
    }
}