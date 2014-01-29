package war.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books*")
public class BookController {

    @Autowired
    BookManager bookManager;

    /*@RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest() throws Exception{
        return new ModelAndView().addObject(bookManager.getBooks());
    }*/

    @RequestMapping("/books*")
    public String execute(ModelMap model) {
        model.addAttribute("bookList", bookManager.getBooks());
        return "bookList";
    }
}
