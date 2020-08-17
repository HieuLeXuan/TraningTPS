package com.hieulexuan.springjwt.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hieulexuan.springjwt.exceptions.UserNotFoundException;
import com.hieulexuan.springjwt.models.User;
import com.hieulexuan.springjwt.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	public User updateUser(User user, String username) throws IOException {

		User currentUser = userRepository.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException(username));

		currentUser.setUsername(user.getUsername());
//		if (currentUser.getPassword() != "") {
//			currentUser.setPassword(encoder.encode(user.getPassword()));
//		}
		currentUser.setEmail(user.getEmail());
		currentUser.setFirstname(user.getFirstname());
		currentUser.setLastname(user.getLastname());
		currentUser.setPhone(user.getPhone());
		currentUser.setLocation(user.getLocation());

		return userRepository.save(currentUser);
	}

	public Stream<User> getAllUsers() {
		return userRepository.findAll().stream();
	}
	
	public void deleteUser(Long id) throws IOException {
		userRepository.deleteById(id);
	}
}
