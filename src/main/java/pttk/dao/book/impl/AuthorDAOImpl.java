package pttk.dao.book.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.book.AuthorDAO;
import pttk.entity.book.Author;
import pttk.entity.book.Publisher;
import pttk.util.impl.AuthorMapper;
import pttk.util.impl.PublisherMapper;

import java.util.List;

public class AuthorDAOImpl extends BaseDAOImpl<Author> implements AuthorDAO {

    @Override
    public Author getAuthorById(int authorId) {
        String sql = "SELECT * FROM Author WHERE ID = ?";
        List<Author> authorList =  query(sql, new AuthorMapper(), authorId);
        return authorList.isEmpty() ? null : authorList.get(0);
    }

    private Publisher getPublisherById(int publisherId) {
        String sql = "SELECT * FROM Publisher WHERE ID = ?";
        List<Publisher> publisherList =  query(sql, new PublisherMapper(), publisherId);
        return publisherList.isEmpty() ? null : publisherList.get(0);
    }

}
