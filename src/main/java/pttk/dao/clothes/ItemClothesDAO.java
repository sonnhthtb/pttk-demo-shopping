package pttk.dao.clothes;

import pttk.dao.BaseDAO;
import pttk.entity.ItemClothes;

import java.util.List;

public interface ItemClothesDAO extends BaseDAO<ItemClothes> {
    List<ItemClothes> findAll();
    List<ItemClothes> findAll(int limit, int offset);
    public int getTotalItem();
    ItemClothes findById(int id);
    List<ItemClothes> findByName(String name);
}
