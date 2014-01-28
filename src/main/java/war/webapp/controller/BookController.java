package war.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

public class BookController {
    @Autowired
    BookManager bookManager;

    @RequestMapping("/books")
    public String execute(ModelMap model) {
        model.addAttribute("bookList", bookManager.getBooks());
        return "bookList";
    }
}
