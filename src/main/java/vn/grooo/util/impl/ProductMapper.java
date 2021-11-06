package vn.grooo.util.impl;

import vn.grooo.dao.CategoryDAO;
import vn.grooo.dao.impl.CategoryDAOImpl;
import vn.grooo.entity.Product;
import vn.grooo.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {

    private final CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    public Product mapRow(ResultSet resultSet) {
        try {
            Product product = new Product();
            product.setId(resultSet.getLong("id"));
            product.setName(resultSet.getString("name"));
            product.setImage(resultSet.getString("image"));
            product.setPrice(resultSet.getFloat("price"));
            product.setDescription(resultSet.getString("description"));
            product.setCategory(categoryDAO.findById(resultSet.getLong("category_id")));
            if (resultSet.getTimestamp("created_at") != null) {
                product.setCreatedAt(resultSet.getTimestamp("created_at"));
            }
            if (resultSet.getString("updated_at") != null) {
                product.setUpdatedAt(resultSet.getTimestamp("updated_at"));
            }
            product.setIsDeleted(resultSet.getBoolean("is_deleted"));
            return product;
        } catch (SQLException e) {
            return null;
        }
    }
}
