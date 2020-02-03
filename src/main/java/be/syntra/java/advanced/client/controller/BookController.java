package be.syntra.java.advanced.client.controller;

import be.syntra.java.advanced.client.model.Book;
import be.syntra.java.advanced.client.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ModelAndView handleGetBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ModelAndView("bookList", "books", books);
    }

    @GetMapping("/detail/{isbn}")
    public ModelAndView handleGetBookByIsbn(@PathVariable("isbn") String isbn) {
        Book book = bookService.getBook(isbn);
        return new ModelAndView("bookDetail", "book", book);
    }

}
