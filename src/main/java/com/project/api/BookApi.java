package com.project.api;

import com.project.dto.BookDto;
import com.project.entity.Book;
import com.project.entity.Genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.project.entity.Author;
import com.project.service.BookService;

import jakarta.validation.Valid;

import java.util.List;

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
	@GetMapping("/{bookId}")
	public Book searchById(@PathVariable  int bookId){
		return bookService.searchBookByID(bookId);

	}
	@GetMapping("/allbooks")
	public List<Book> allBooks(){
		return bookService.allBooks();
	}
	@GetMapping("/genre")
	public List<Book> searchByGenre(@RequestParam("genre") Genre genre){
		return bookService.searchByGenre(genre);
	}
	@GetMapping("/page")
	public List<Book> alllBooksWithPagination(@RequestParam("pageno") int pageNo,@RequestParam("size") int size){
		Page<Book> bookPage=bookService.allBooksWithPagination(pageNo,size);
		return bookPage.toList();
	}

}
