package com.accenture;

import com.accenture.entity.Book;
import com.accenture.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphQlApplication implements CommandLineRunner{
	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book b1= new Book();
		b1.setTitle("Complete Reference");
		b1.setDesc("For learning Java");
		b1.setPages(2000);
		b1.setPrice(500);
		b1.setAuthor("Satyam");

		Book b2= new Book();
		b2.setTitle("Java for beginners");
		b2.setDesc("Beginner concepts");
		b2.setPages(300);
		b2.setPrice(1000);
		b2.setAuthor("Simran");

		bookService.create(b1);
		bookService.create(b2);
	}
}
