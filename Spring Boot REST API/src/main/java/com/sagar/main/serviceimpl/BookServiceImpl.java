package com.sagar.main.serviceimpl;

import java.util.List;

import com.sagar.main.dao.BookDao;
import com.sagar.main.entity.Book;
import com.sagar.main.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    public BookServiceImpl() {
    }

    public List<Book> getAllBooks() {
        return this.bookDao.findAll();
    }

    public void saveBook(Book book) {
        this.bookDao.save(book);
    }

    public void updateBook(Book book) {
        this.bookDao.save(book);
    }

    public void deleteBook(int id) {
        this.bookDao.deleteById(id);
    }
}
