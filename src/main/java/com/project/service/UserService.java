package com.project.service;

import com.project.entity.Book;
import com.project.entity.Transaction;
import com.project.entity.User;

import java.util.List;

public interface UserService {
    User addNewUser(User u);
   // Book borrowBook(BorrowBookDto borrowBookDto );
    //Book returnBook(int tid);
    boolean checkAvailability(int bookId);
    List<Transaction> chkTransactionByUser(int userId);
}
