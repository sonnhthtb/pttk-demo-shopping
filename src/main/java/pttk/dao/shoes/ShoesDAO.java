package pttk.dao.shoes;

import pttk.dao.BaseDAO;
import pttk.model.shoes.Shoes;



public interface ShoesDAO extends BaseDAO<Shoes> {
    Shoes getShoesByItemShoesId(int itemShoesId);

}
