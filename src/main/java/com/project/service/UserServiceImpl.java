package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Transaction;
import com.project.entity.User;
import com.project.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User addNewUser(User u) {
		// TODO Auto-generated method stub
		userRepo.save(u);
		return u;
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
