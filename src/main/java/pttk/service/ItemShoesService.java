package pttk.service;



import pttk.model.shoes.ItemShoes;

import java.util.List;

public interface ItemShoesService {
    ItemShoes findShoesById(int ItemShoesId);
    List<ItemShoes> findAllItemShoes();
    List<ItemShoes> findAll(int limit, int offset);
    List<ItemShoes> findByName(String name);
    List<ItemShoes> getAllShoesForMan();
    List<ItemShoes> getAllShoesForWomen();
    int getTotalItem();
}
