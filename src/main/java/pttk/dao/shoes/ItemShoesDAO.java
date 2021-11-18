package pttk.dao.shoes;

import pttk.dao.BaseDAO;
import pttk.model.shoes.ItemShoes;

import java.util.List;

public interface ItemShoesDAO extends BaseDAO<ItemShoes> {
    List<ItemShoes> findAll();
    List<ItemShoes> findAll(int limit, int offset);
    public int getTotalItem();
    ItemShoes findById(int id);
    List<ItemShoes> findByName(String name);
}
