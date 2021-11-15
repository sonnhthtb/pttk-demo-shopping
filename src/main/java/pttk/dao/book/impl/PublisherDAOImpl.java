package pttk.dao.book.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.book.AuthorDAO;
import pttk.dao.book.PublisherDAO;
import pttk.entity.Author;
import pttk.entity.Publisher;
import pttk.util.impl.AuthorMapper;
import pttk.util.impl.PublisherMapper;

import java.util.List;

public class PublisherDAOImpl extends BaseDAOImpl<Publisher> implements PublisherDAO {
    @Override
    public Publisher getPublisherById(int publisherId) {
        String sql = "SELECT * FROM Publisher WHERE ID = ?";
        List<Publisher> publisherList =  query(sql, new PublisherMapper(), publisherId);
        return publisherList.isEmpty() ? null : publisherList.get(0);
    }

}
