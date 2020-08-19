package com.hieulexuan.uploadimages.service;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hieulexuan.uploadimages.exceptions.UserNotFoundException;
import com.hieulexuan.uploadimages.models.User;
import com.hieulexuan.uploadimages.repository.UserRepository;

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
	
	public Optional<User> findById(Long userid) {
		return userRepository.findById(userid);
	}

	public void save(User user) {
		userRepository.save(user);
	}
	
}
