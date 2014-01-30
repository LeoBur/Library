package war.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BookController {

    @Autowired
    BookManager bookManager;

    public String execute(ModelMap model) {
        model.addAttribute("bookList", bookManager.getBooks());
        return "bookList";
    }
}
