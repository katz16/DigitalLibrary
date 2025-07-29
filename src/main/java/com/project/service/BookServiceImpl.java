package com.project.service;

import java.util.List;

import com.project.dto.BookDto;
import com.project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.project.entity.Author;
import com.project.entity.Book;
import com.project.entity.Genre;
import com.project.repository.AuthorRepository;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private AuthorRepository authorrepo;
	@Autowired
	private BookRepository bookrepo;
	@Override
	public Author addAuthor(Author author) {
		authorrepo.save(author);
		return author;
	}

	@Override
	public Book addBook(BookDto bookDto) {
		int authorId=bookDto.getAuthorId();
		Author author= authorrepo.findById(authorId).get();
		Book book = new Book();
		book.setBookId(bookDto.getBookId());
		book.setBookName(bookDto.getBookName());
		book.setPublishedDate(bookDto.getPublishedDate());
		book.setCost(bookDto.getCost());
		book.setStock(bookDto.getStock());
		book.setGenre(bookDto.getGenre());
		book.setAuthorId(author);

		return bookrepo.save(book);
	}

	@Override
	public List<Book> searchByGenre2(Genre genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> allBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Book> allBooksWithPagination(int pageNo, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchByAuthor(int authorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchByGenre(Genre genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book updateBook(BookDto book, int bookId) {
		return null;
	}

	@Override
	public void removeBook(int bookId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> searchByBookName(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCost(int bookId, float cost) {
		// TODO Auto-generated method stub
		return 0;
	}

}
