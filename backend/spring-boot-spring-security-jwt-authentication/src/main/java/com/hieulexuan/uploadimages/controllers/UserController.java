package com.hieulexuan.uploadimages.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hieulexuan.uploadimages.message.ResponseMessage;
import com.hieulexuan.uploadimages.message.ResponseUser;
import com.hieulexuan.uploadimages.models.User;
import com.hieulexuan.uploadimages.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<List<ResponseUser>> getListFiles() {
		List<ResponseUser> users = userService.getAllUsers().map(dbUser -> {

			return new ResponseUser(dbUser.getId(), dbUser.getUsername(), dbUser.getFirstname(), dbUser.getLastname(),
					dbUser.getEmail(), dbUser.getLocation(), dbUser.getPhone(), dbUser.getRoles());
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@PutMapping("/users")
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

	@DeleteMapping("users/{id}")
	public void deleteImage(@PathVariable Long id) throws IOException {
		userService.deleteUser(id);
	}
}