package vn.grooo.service;

import vn.grooo.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);
}
