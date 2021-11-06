package vn.grooo.dao.impl;

import vn.grooo.dao.ProductDAO;
import vn.grooo.entity.Product;
import vn.grooo.util.impl.ProductMapper;

import java.util.List;

public class ProductDAOImpl extends BaseDAOImpl<Product> implements ProductDAO {
    @Override
    public Product save(Product product) {
        String sql  = "INSERT INTO Product(name, description, price, image, created_at, category_id) VALUES(?, ?, ?, ? ,? ,?)";
        Long id = insert(sql, product.getName(), product.getDescription(), product.getPrice(), product.getImage(),
                product.getCreatedAt(), product.getCategory().getId());
        return findById(id);
    }

    @Override
    public Product update(Product product) {
        String sql = "UPDATE Product SET name = ?, description = ?, price = ?, image = ?, updated_at = ?," +
                " category_id = ? WHERE id = ?";
        update(sql, product.getName(), product.getDescription(), product.getPrice(), product.getImage(),
                product.getUpdatedAt(), product.getCategory().getId(), product.getId());
        return findById(product.getId());
    }

    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM product WHERE is_deleted = 0";
        return query(sql, new ProductMapper());
    }

    @Override
    public List<Product> findAll(int offset, int limit) {
        String sql = "SELECT * FROM product WHERE is_deleted = 0 LIMIT ? , ?";
        return query(sql, new ProductMapper(), offset, limit);
    }

    @Override
    public List<Product> findByCategoryId(String id) {
        String sql = "SELECT * FROM product WHERE is_deleted = 0 AND category_id = ?";
        return query(sql, new ProductMapper(), id);
    }

    @Override
    public List<Product> findByCategoryId(String id, int offset, int limit) {
        String sql = "SELECT * FROM product WHERE is_deleted = 0 AND category_id = ? LIMIT ?, ?";
        return query(sql, new ProductMapper(), id, offset, limit);
    }

    @Override
    public List<Product> findByNameLike(String name) {
        String sql = "SELECT * FROM product WHERE is_deleted = 0 AND name like ?";
        return query(sql, new ProductMapper(), "%"+name+"%");
    }

    @Override
    public List<Product> findByNameLike(String name, int offset, int limit) {
        String sql = "SELECT * FROM product WHERE is_deleted = 0 AND name like ? LIMIT ?, ?";
        return query(sql, new ProductMapper(), "%"+name+"%", offset, limit);
    }

    @Override
    public Product findById(Long id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        List<Product> productList = query(sql, new ProductMapper(), id);
        return productList.isEmpty() ? null : productList.get(0);
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM product WHERE is_deleted = 0";
        return count(sql);
    }

    @Override
    public int getTotalItemByCategoryId(String id) {
        String sql = "SELECT count(*) FROM product WHERE is_deleted = 0 AND category_id = ?";
        return count(sql, id);
    }

    @Override
    public void delete(Long id) {
        String sql = "UPDATE Product SET is_deleted = 1 WHERE id = ?";
        update(sql, id);
    }
}
