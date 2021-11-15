package pttk.dao.book;

import pttk.dao.BaseDAO;
import pttk.entity.Author;
import pttk.entity.Publisher;

public interface PublisherDAO extends BaseDAO<Publisher> {
    Publisher getPublisherById(int publisherId);
}
