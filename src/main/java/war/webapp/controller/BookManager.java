package war.webapp.controller;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import war.webapp.DAO.BookDao;
import war.webapp.DAO.BookExistException;
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
    
    public Book getBook(Long id){
        return bookDao.get(id);
    }
    
    public List<Book> getBooks(){
        return bookDao.getBooks();
    }
    
    public Book saveBook(Book book) throws BookExistException {
        
        try{
            return bookDao.saveBook(book);
        } catch (DataIntegrityViolationException e){
            throw new BookExistException("Book entitled '" + book.getTitle() + "' already exists");
        } catch (JpaSystemException e){
            throw new BookExistException("Book entitled '" + book.getTitle() + "' already exists");
        }
    }

    public void removeBook(Long isbn) throws BookNotFoundException{
            bookDao.remove(bookDao.loadBookByIsbn(isbn).getId());
    }

    public Book getBookByTitle(String title) throws BookNotFoundException {
        return (Book) bookDao.loadBookByTitle(title);
    }
}
