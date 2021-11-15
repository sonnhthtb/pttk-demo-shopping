package pttk.service;

import pttk.entity.ItemBook;

import java.util.List;

public interface ItemBookService {
    List<ItemBook> findAll();
    List<ItemBook> findAll(int limit, int offset);
    int getTotalItem();
}
