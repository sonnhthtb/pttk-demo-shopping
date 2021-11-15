package pttk.dao.book;

import pttk.dao.BaseDAO;
import pttk.entity.Author;
import pttk.entity.Book;

public interface AuthorDAO  extends BaseDAO<Author> {
    Author getAuthorById(int authorId);
}
