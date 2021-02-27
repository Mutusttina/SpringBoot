package com.sagar.main.controller;

import com.sagar.main.entity.Book;
import com.sagar.main.service.BookService;
import com.sagar.main.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping({"/book"})
public class BooksController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ExcelService excelService;

    public BooksController() {
    }

    @GetMapping({"/list"})
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping({"/save"})
    public List<Book> saveBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return getAllBooks();
    }

    @PutMapping({"/update"})
    public List<Book> update(@RequestBody Book book) {
        bookService.updateBook(book);
        return getAllBooks();
    }

    @DeleteMapping({"/delete/{id}"})
    public List<Book> delete(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return getAllBooks();
    }

    @GetMapping({"/excel"})
    public boolean generateExcel() throws FileNotFoundException, SQLException {
        return excelService.generateExcel();
    }
}