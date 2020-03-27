package com.social.imageApp.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.social.imageApp.account.model.User;
import com.social.imageApp.account.service.UserService;

@RestController
public class UserController {

	@Autowired(required = true)
	private UserService userService;

	/* 
	 * add User
	 *  */
	@PostMapping("/add")
	public ResponseEntity<?> save(@RequestBody User user) {
		int id = userService.save(user);
		return ResponseEntity.ok().body("New user has been saved with ID:" + id);
	}
	
	/* 
	 * Single select
	 *  */
	@GetMapping("/user/{id}")
	public ResponseEntity<User> get(@PathVariable("id") int userId) {
		User user = userService.get(userId);
		return ResponseEntity.ok().body(user);
	}
	
	/* 
	 * Multi select
	 *  */
	@GetMapping("/users")
	public ResponseEntity<List<User>> list() {
		List<User> users = userService.list();
		return ResponseEntity.ok().body(users);
	}

	/* 
	 * Update User
	 *  */
	@PutMapping("/user/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int userId, @RequestBody User user) {
		userService.update(userId, user);
		return ResponseEntity.ok().body("Book has been updated successfully.");
	}

	/*
	 * Delete user by id
	 * */
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int userId) {
		userService.delete(userId);
		return ResponseEntity.ok().body("Book has been deleted successfully.");
	}

}
