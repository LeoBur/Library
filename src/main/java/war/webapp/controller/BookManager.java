package war.webapp.controller;

import org.appfuse.service.GenericManager;
import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import war.webapp.DAO.BookDao;
import war.webapp.DAO.BookNotFoundException;
import war.webapp.Entities.Book;

import java.util.List;


@Service("bookManager")
public class BookManager extends GenericManagerImpl<Book, Long>{
    
    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.dao = bookDao;
        this.bookDao = bookDao;
    }
    
    public Book getBook(Long isbn){
        return bookDao.get(isbn);
    }
    
    public List<Book> getBooks(){
        return bookDao.getAllDistinct();
    }
    
    public Book saveBook(Book book) throws BookExistException {
        
        try{
            return bookDao.saveBook(book);
        } catch (DataIntegrityViolationException e){
            throw new BookExistException("Book already exists");
        } catch (JpaSystemException e){
            throw new BookExistException("User already exists");
        }
    }

    public void removeBook(Long isbn) {
        try {
            bookDao.remove(bookDao.loadBookByIsbn(isbn).getId());
        } catch (BookNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public Book getBookByTitle(String title) throws BookNotFoundException {
        return (Book) bookDao.loadBookByTitle(title);
    }
}
