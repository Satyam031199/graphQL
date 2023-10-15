package com.accenture.controller;

import com.accenture.entity.Book;
import com.accenture.service.BookService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @MutationMapping("createBook")
    public Book create(@Argument BookInput book){
        Book b=new Book();
        b.setTitle(book.getTitle());
        b.setDesc(book.getDesc());
        b.setPrice(book.getPrice());
        b.setAuthor(book.getAuthor());
        b.setPages(book.getPages());
        return this.bookService.create(b);
    }
    @QueryMapping("allBooks")
    public List<Book> getAll(){
        return bookService.getAll();
    }
    @QueryMapping("getBook")
    public Book get(@Argument int bookId){
        return bookService.get(bookId);
    }
}

@Data
class BookInput{
    private String title;
    private String desc;
    private String author;
    private double price;
    private int pages;
}
