package com.Anish.Create.a.Portal.service;

import com.Anish.Create.a.Portal.model.Book;
import com.Anish.Create.a.Portal.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;


    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookById(String id) {
        return bookRepo.findById(id).orElse(null);
    }

    public void saveBook(Book book) {
        bookRepo.save(book);
    }

    public void updateBook(String id, Book updatedBook) {
        Book book = bookRepo.findById(id).orElse(null);
        if (book != null) {
            // Update book fields here
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setDescription(updatedBook.getDescription());
            book.setPrice(updatedBook.getPrice());

            bookRepo.save(book);
        }
    }

    public void deleteBook(String id) {
        bookRepo.deleteById(id);
    }
}
