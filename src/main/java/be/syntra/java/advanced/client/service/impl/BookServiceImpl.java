package be.syntra.java.advanced.client.service.impl;

import be.syntra.java.advanced.client.model.Book;
import be.syntra.java.advanced.client.model.BookList;
import be.syntra.java.advanced.client.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private RestTemplate template;

    @Autowired
    public BookServiceImpl(RestTemplate template) {
        this.template = template;
    }

    @Override
    public List<Book> getAllBooks() {
        BookList bookList = template.getForObject("/books", BookList.class);
        return bookList.getBooks();
    }

    @Override
    public Book getBook(String isbn) {
        Book book = template.getForObject("/books/" + isbn, Book.class);
        return book;
    }
}
