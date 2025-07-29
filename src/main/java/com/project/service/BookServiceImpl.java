package com.project.service;

import java.util.List;

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
	@Override
	public Author addAuthor(Author author) {
		authorrepo.save(author);
		return author;
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
