package war.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import war.webapp.DAO.BookExistException;
import war.webapp.DAO.BookNotFoundException;
import war.webapp.Entities.Book;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/bookForm*")
public class BookFormController extends BaseFormController{

    @Autowired
    BookManager bookManager;

    @Autowired
    Validator validator;

    private MessageSourceAccessor messages;

    @Autowired
    public void setMessages(MessageSource messageSource) {
        messages = new MessageSourceAccessor(messageSource);
    }

    public BookFormController(){
        setCancelView("redirect:books");
        setSuccessView("redirect:books");
    }

    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Long.class, null,
                new CustomNumberEditor(Long.class, null, true));
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Book book, BindingResult result, HttpServletRequest request) throws BookNotFoundException, BookExistException {

        if (request.getParameter("cancel") != null)
            return "redirect:/";


        if (validator != null) { // validator is null during testing
            validator.validate(book, result);

            if (result.hasErrors()) {
                return "bookForm";
            }
        }

        if (request.getParameter("delete") != null) {
                bookManager.removeBook(book.getIsbn());
            request.getSession().setAttribute("message",
                    getText("book.deleted", book.getTitle()));
        } else {
                bookManager.saveBook(book);
            request.getSession().setAttribute("message",
                    getText("book.saved", book.getTitle()));
        }

        return "redirect:/";
    }

    @ModelAttribute
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    protected Book getBook(HttpServletRequest request) {
        Long bookId = (Long.getLong(request.getParameter("isbn")));
        if ((bookId != null) && !bookId.equals("")) {
            return bookManager.getBook(bookId);
        } else {
            return new Book();
        }
    }

    public String getText(String msgKey) {
        return messages.getMessage(msgKey);
    }

    public String getText(String msgKey, String arg) {
        return getText(msgKey, new Object[]{arg});
    }

    public String getText(String msgKey, Object[] args) {
        return messages.getMessage(msgKey, args);
    }

}
