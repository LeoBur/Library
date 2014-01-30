package war.webapp.DAO;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;
import war.webapp.Entities.Book;

import java.util.List;

@Repository
public class BookDao extends GenericDaoHibernate<Book, Long> {

    /**
     * Constructor that sets the entity to User.class.
     */
    public BookDao() {
        super(Book.class);
    }

    @SuppressWarnings("unchecked")
    public List<Book> getBooks() {
        return getHibernateTemplate().find("SELECT * FROM Book");
    }

    public Book saveBook(Book book) {

        getHibernateTemplate().saveOrUpdate(book);
        // necessary to throw a DataIntegrityViolation and catch it in BookManager
        getHibernateTemplate().flush();
        return book;
    }

    /**
     * Overridden simply to call the saveBook method. This is happenening
     * because saveBook flushes the session and saveObject of BaseDaoHibernate
     * does not.
     *
     * @param book the book to save
     * @return the modified book (with a primary key set if they're new)
     */
    @Override
    public Book save(Book book) {
        return this.saveBook(book);
    }

    public Book loadBookByTitle(String title) throws BookNotFoundException {
        List book = getHibernateTemplate().find("from Book where title=?", title);
        if (book == null || book.isEmpty()) {
            throw new BookNotFoundException("Book entitled '" + title + "' was not found...");
        } else {
            return (Book) book.get(0);
        }
    }

    public Book loadBookByIsbn(Long isbn) throws BookNotFoundException{
        List book = getHibernateTemplate().find("from Book where isbn=?", isbn);
        if (book == null || book.isEmpty()) {
            throw new BookNotFoundException("Book with ISBN N° '" + isbn + "' was not found...");
        } else {
            return (Book) book.get(0);
        }
    }

}
