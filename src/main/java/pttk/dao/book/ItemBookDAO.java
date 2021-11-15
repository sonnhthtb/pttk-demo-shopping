package pttk.dao.book;

import pttk.dao.BaseDAO;
import pttk.entity.ItemBook;

import java.util.List;

public interface ItemBookDAO extends BaseDAO<ItemBook> {
    List<ItemBook> findAll();
    List<ItemBook> findAll(int limit, int offset);
    public int getTotalItem();
}
