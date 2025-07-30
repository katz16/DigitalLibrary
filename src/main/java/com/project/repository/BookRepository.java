package com.project.repository;

import com.project.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer>{
    // by query method findBy<field name>
    List<Book> findByGenre(Genre genre);
    //using own jpql query
    //@Query(value="select b from Book where b.genre= :g") //jpql query
    //List<Book> searchBookByGenre(@Param("g") Genre genre);

    List<Book> findByBookName(String bookName);
    //using own native sql query
    @Query(value="select * from Book where book_name= :n", nativeQuery = true) //native query is sql query
    //and not jpql
    List<Book> searchBookByName(@Param("n") String bookName);

}
