package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
