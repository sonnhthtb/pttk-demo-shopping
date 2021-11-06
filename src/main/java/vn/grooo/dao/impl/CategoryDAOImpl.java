package vn.grooo.dao.impl;

import vn.grooo.dao.CategoryDAO;
import vn.grooo.entity.Category;
import vn.grooo.util.impl.CategoryMapper;

import java.util.List;

public class CategoryDAOImpl extends BaseDAOImpl<Category> implements CategoryDAO {
    @Override
    public List<Category> findAll() {
        String sql = "SELECT * FROM category";
        return query(sql, new CategoryMapper());
    }

    @Override
    public Category findById(Long id) {
        String sql = "SELECT * FROM category WHERE id = ?";
        List<Category> categories =  query(sql, new CategoryMapper(), id);
        return categories.isEmpty() ? null : categories.get(0);
    }
}
