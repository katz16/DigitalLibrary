package com.project.service;

import java.util.List;

import com.project.dto.BorrowBookDto;
import com.project.entity.Book;
import com.project.exception.ApplicationException;
import com.project.repository.BookRepository;
import com.project.repository.PenaltyRepository;
import com.project.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Transaction;
import com.project.entity.User;
import com.project.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private PenaltyRepository penaltyRepo;
	@Autowired
	private TransactionRepository tranRepo;
	@Override
	public User addNewUser(User u) {
		// TODO Auto-generated method stub
		userRepo.save(u);
		return u;
	}

	@Override
	public Book borrowBook(BorrowBookDto borrowBookDto) {
		int userId = borrowBookDto.getUserId();
		int bookId = borrowBookDto.getBookId();
		User user = userRepo.findById(userId).orElseThrow(()-> new ApplicationException("User not found with id: " + userId));
		Book book = bookRepo.findById(bookId).orElseThrow(()-> new ApplicationException("Book not found with id: " + bookId));
		if(book.getStock()>0) {
			Transaction t = new Transaction();
			t.setBook(book);
			t.setUser(user);
			t.setAmount(book.getCost());
			t.setStatus("BORROWED");
			book.setStock(book.getStock() - 1);
			tranRepo.save(t);

			return bookRepo.save(book);
		}
		else{
			throw new ApplicationException("Sorry..Stock is over !");
		}
	}

	@Override
	public boolean checkAvailability(int bookId) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public List<Transaction> chkTransactionByUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
