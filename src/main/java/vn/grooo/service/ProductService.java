package vn.grooo.service;

import vn.grooo.entity.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);
    Product update(Product product);
    List<Product> findAll();
    List<Product> findAll(int offset, int limit);
    List<Product> findByCategoryId(String id);
    List<Product> findByCategoryId(String id, int offset, int limit);
    List<Product> findByNameLike(String name);
    List<Product> findByNameLike(String name, int offset, int limit);
    Product findById(Long id);
    int getTotalItem();
    int getTotalItemByCategoryId(String categoryId);
    void delete(String[] ids);
}
