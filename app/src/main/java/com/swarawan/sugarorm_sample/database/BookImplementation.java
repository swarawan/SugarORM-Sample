package com.swarawan.sugarorm_sample.database;

import java.util.List;

/**
 * Created by rioswarawan on 11/14/17.
 */

public class BookImplementation {

    public void saveOrUpdate(Book book) {
        int id = book.id;
        Book existingBook = Book.findById(Book.class, id);
        if (null == existingBook) {
            save(book);
        } else {
            update(book);
        }
    }

    public void save(Book book) {
        book.save();
    }

    public void update(Book book) {
        long id = book.id;
        Book existingBook = Book.findById(Book.class, id);
        existingBook.title = book.title;
        existingBook.author = book.author;
        existingBook.genre = book.genre;
        existingBook.save();
    }

    public void remove(Book book) {
        long id = book.id;
        Book existingBook = Book.findById(Book.class, id);
        existingBook.delete();
    }

    public void removeAll() {
        Book.deleteAll(Book.class);
    }

    public Book getOne(long id) {
        return Book.findById(Book.class, id);
    }

    public List<Book> getAll() {
        return Book.listAll(Book.class);
    }
}
