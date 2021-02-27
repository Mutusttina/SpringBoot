package com.sagar.main.service;

import com.sagar.main.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    void saveBook(Book user);

    void updateBook(Book user);

    void deleteBook(int id);
}
