package com.project.service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import com.project.dto.BorrowBookDto;
import com.project.entity.Book;
import com.project.entity.Penalty;
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
	public Book returnBook(int tid) {
		Transaction t=tranRepo.findById(tid).orElseThrow(()-> new ApplicationException("invalid Transaction id: " + tid));
		LocalDate borrowDate = t.getBorrowedDate();
		LocalDate returnDate = LocalDate.now();
		Book book=t.getBook();
		//LocalDate.atStartOfDay() is used to convert LocalDate to LocalDateTime
		Duration duration=Duration.between(borrowDate.atStartOfDay(),returnDate.atStartOfDay());
		long noOfDays= duration.toDays();
		if(t.getStatus().equalsIgnoreCase("BORROWED")) {
			if (noOfDays > 7) {
				Penalty p= new Penalty();
				p.setAmount((noOfDays-30)*50);
				p.setRemarks("total "+noOfDays);
				p.setNoOfDays((int)noOfDays);
				t.setPenalty(p);
				penaltyRepo.save(p);
				t.setStatus("RETURNED");
				tranRepo.save(t);
				Book b= t.getBook();
				b.setStock(b.getStock() + 1);
				bookRepo.save(b);
			} else {

				book.setStock(book.getStock() + 1);
				t.setReturnedDate(returnDate);
				t.setStatus("RETURNED");
				bookRepo.save(book);
				tranRepo.save(t);

			}
		}
		else{
			throw new ApplicationException("Book is already returned");
		}
		return book;

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
