package com.accenture.service;

import com.accenture.entity.Book;
import com.accenture.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book create(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book get(int bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

}
