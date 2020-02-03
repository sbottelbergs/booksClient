package be.syntra.java.advanced.client.service;

import be.syntra.java.advanced.client.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBook(String isbn);
}
