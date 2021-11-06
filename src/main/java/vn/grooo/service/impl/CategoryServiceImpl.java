package vn.grooo.service.impl;

import vn.grooo.dao.CategoryDAO;
import vn.grooo.dao.impl.CategoryDAOImpl;
import vn.grooo.entity.Category;
import vn.grooo.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryDAO.findById(id);
    }
}
