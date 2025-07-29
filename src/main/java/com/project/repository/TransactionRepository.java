package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
