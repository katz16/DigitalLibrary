package com.project.api;

import com.project.dto.BookDto;
import com.project.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Author;
import com.project.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookApi {
	@Autowired
	private BookService bookService;
	
	@PostMapping("/authors")
	public Author addNewAuthor(@RequestBody @Valid Author author) {

		return bookService.addAuthor(author);
	}
	@PostMapping("/addbook")
	public Book addNewBook(@RequestBody @Valid BookDto book) {
		return bookService.addBook(book);
	}

}
