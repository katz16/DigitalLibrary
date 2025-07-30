package com.project.service;

import com.project.dto.BookDto;
import com.project.entity.Author;
import com.project.entity.Book;
import com.project.entity.Genre;
import org.springframework.data.domain.Page;


import java.util.List;

public interface BookService {
    Author addAuthor(Author author);
   Book addBook(BookDto book);
    List<Book> searchByGenre2(Genre genre);
    List<Book> allBooks();
    Page<Book> allBooksWithPagination(int pageNo, int size);
    List<Book> searchByAuthor(int authorId);
    List<Book> searchByGenre(Genre genre);
    Book updateBook(BookDto book, int bookId);
    void removeBook(int bookId);
    List<Book> searchByBookName(String bookName);
    int updateCost(int bookId, float cost);
    Book searchBookByID(int bookId);


}
