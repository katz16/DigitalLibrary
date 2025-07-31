package com.project.api;

import com.project.dto.BorrowBookDto;
import com.project.entity.Book;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.entity.User;
import com.project.service.UserService;

@RestController
@RequestMapping("/users")
public class UserApi {
	@Autowired
	private UserService userService;
	@PostMapping
	public User addNewUser(@RequestBody User u) {
		return userService.addNewUser(u);
	}
	@PostMapping("/borrow")
	public Book borrowBook(@RequestBody @Valid BorrowBookDto borrowBookDto){
		return userService.borrowBook(borrowBookDto);
	}
	@PutMapping("/returnbook/{tid}")
	public Book returnBook(@PathVariable("tid") int tid) {
		return userService.returnBook(tid);
	}
}