package vn.grooo.util.impl;

import vn.grooo.entity.Category;
import vn.grooo.entity.Product;
import vn.grooo.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet resultSet) {
        try {
            Category category = new Category();
            category.setId(resultSet.getLong("id"));
            category.setName(resultSet.getString("name"));
            category.setCode(resultSet.getString("code"));
            if (resultSet.getTimestamp("created_at") != null) {
                category.setCreatedAt(resultSet.getTimestamp("created_at"));
            }
            if (resultSet.getString("updated_at") != null) {
                category.setUpdatedAt(resultSet.getTimestamp("updated_at"));
            }
            category.setIsDeleted(resultSet.getBoolean("is_deleted"));
            return category;
        } catch (SQLException e) {
            return null;
        }
    }
}
