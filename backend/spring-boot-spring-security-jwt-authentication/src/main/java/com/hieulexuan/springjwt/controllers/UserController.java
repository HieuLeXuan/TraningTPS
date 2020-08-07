package com.hieulexuan.springjwt.controllers;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hieulexuan.springjwt.message.ResponseMessage;
import com.hieulexuan.springjwt.models.User;
import com.hieulexuan.springjwt.repository.UserRepository;
import com.hieulexuan.springjwt.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@PutMapping("/users")
	public ResponseEntity<ResponseMessage> updateUser(@RequestBody User user, Principal principal) {
		String message = "";
		try {
			userService.updateUser(user, principal.getName());
			System.out.println(user.getPhone() + user.getPassword());
			message = "Uploaded user successfully!";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (IOException e) {
			message = "Could not upload user!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
}