package com.hieulexuan.springjwt.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hieulexuan.springjwt.message.ResponseMessage;
import com.hieulexuan.springjwt.message.ResponseUser;
import com.hieulexuan.springjwt.models.User;
import com.hieulexuan.springjwt.repository.UserRepository;
import com.hieulexuan.springjwt.security.services.UserDetailsImpl;
import com.hieulexuan.springjwt.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/users")
	public ResponseEntity<List<ResponseUser>> getListFiles() {
		List<ResponseUser> users = userService.getAllUsers().map(dbUser -> {

			return new ResponseUser(dbUser.getId(), dbUser.getUsername(), dbUser.getFirstname(), dbUser.getLastname(),
					dbUser.getEmail(), dbUser.getLocation(), dbUser.getPhone(), dbUser.getRoles());
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@PutMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<ResponseMessage> updateUser(@RequestBody User user, Principal principal) {
		String message = "";
		try {
			userService.updateUser(user, principal.getName());
			message = "Uploaded user successfully! " + principal.getName();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (IOException e) {
			message = "Could not upload user!" + principal.getName();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
}