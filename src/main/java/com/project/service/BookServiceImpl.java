package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.dto.BookDto;
import com.project.exception.ApplicationException;
import com.project.repository.BookRepository;
import org.springframework.beans.BeanUtils;
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
		Optional<Author> authorOptional = authorrepo.findById(authorId);
		if(authorOptional.isPresent()){
			Author author=	authorOptional.get();
			Book book = new Book();
			//Both BookDto and Book have same getters and setters. So we can use the BeanUtils.copyProperties
			// method to copy properties from bookDto to book.
			/*book.setBookId(bookDto.getBookId());
			book.setBookName(bookDto.getBookName());
			book.setPublishedDate(bookDto.getPublishedDate());
			book.setCost(bookDto.getCost());
			book.setStock(bookDto.getStock());
			book.setGenre(bookDto.getGenre());*/
			BeanUtils.copyProperties(bookDto,book);
			book.setAuthorId(author);

			return bookrepo.save(book);
		}
		 else{
			 throw new ApplicationException("Author not found with id: " + authorId);
		}

	}

	@Override
	public List<Book> searchByGenre2(Genre genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> allBooks() {
		// TODO Auto-generated method stub
		return bookrepo.findAll();
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

	@Override
	public Book searchBookByID(int bookId) {
		 return bookrepo.findById(bookId).orElseThrow(() -> new ApplicationException("Book not found with id: " + bookId));
	}

}
