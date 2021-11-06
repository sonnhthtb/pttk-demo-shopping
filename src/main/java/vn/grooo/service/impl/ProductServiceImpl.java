package vn.grooo.service.impl;

import vn.grooo.dao.ProductDAO;
import vn.grooo.dao.impl.ProductDAOImpl;
import vn.grooo.entity.Product;
import vn.grooo.service.ProductService;

import java.sql.Timestamp;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO = new ProductDAOImpl();


    @Override
    public Product save(Product product) {
        product.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return productDAO.save(product);
    }

    @Override
    public Product update(Product product) {
        product.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return productDAO.update(product);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public List<Product> findAll(int offset, int limit) {
        return productDAO.findAll(offset, limit);
    }


    @Override
    public List<Product> findByCategoryId(String id) {
        return productDAO.findByCategoryId(id);
    }

    @Override
    public List<Product> findByCategoryId(String id, int offset, int limit) {
        return productDAO.findByCategoryId(id, offset, limit);
    }

    @Override
    public List<Product> findByNameLike(String name) {
        return productDAO.findByNameLike(name);
    }

    @Override
    public List<Product> findByNameLike(String name, int offset, int limit) {
        return productDAO.findByNameLike(name, offset, limit);
    }

    @Override
    public Product findById(Long id) {
        return productDAO.findById(id);
    }

    @Override
    public int getTotalItem() {
        return productDAO.getTotalItem();
    }

    @Override
    public int getTotalItemByCategoryId(String categoryId) {
        return productDAO.getTotalItemByCategoryId(categoryId);
    }

    @Override
    public void delete(String[] ids) {
        for(String id: ids) {
            productDAO.delete(Long.parseLong(id));
        }
    }
}
