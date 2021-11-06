package vn.grooo.dao;

import vn.grooo.entity.Category;

import java.util.List;

public interface CategoryDAO extends BaseDAO<Category>{

    List<Category> findAll();
    Category findById(Long id);

}
