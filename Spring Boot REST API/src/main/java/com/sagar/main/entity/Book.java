package com.sagar.main.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table( name = "books")
public class Book {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    protected int id;
    protected String bookName;
    protected String ISBN;
    protected String author;



    public static List<String> getColumnNames() {
        return Arrays.asList("ID", "NAME", "ISBN", "AUTHOR");
    }

    public int getId() {
        return this.id;
    }

    public String getBookName() {
        return this.bookName;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setBookName(final String bookName) {
        this.bookName = bookName;
    }

    public void setISBN(final String ISBN) {
        this.ISBN = ISBN;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

}