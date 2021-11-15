package vn.grooo.dao;

import vn.grooo.util.RowMapper;

import java.util.List;
import java.util.Queue;

public interface BaseDAO<T> {

    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
    void update (String sql, Object... parameters);
    Long insert (String sql, Object... parameters);
    int count(String sql, Object... parameters);
}
