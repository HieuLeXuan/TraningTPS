package com.hieulexuan.springjwt.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hieulexuan.springjwt.exceptions.UserNotFoundException;
import com.hieulexuan.springjwt.models.Image;
import com.hieulexuan.springjwt.models.User;
import com.hieulexuan.springjwt.repository.ImageRepository;
import com.hieulexuan.springjwt.repository.UserRepository;

@Service
public class FileStorageService {

	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private UserRepository userRepository;

	private final Path root = Paths.get("uploads");

	//
	public void init() {
		try {
			Files.createDirectories(root);
		} catch (Exception e) {
			throw new RuntimeException("Could not initialize folder for upload!");
		}
	}

	//
	public Image store(MultipartFile file, String description, String username) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		java.util.Date date = new java.util.Date();
		
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException(username));
		
		Image image = new Image(fileName, file.getContentType(), file.getBytes(), description, date, root.toString(), user);
		
		Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
		return imageRepository.save(image);
	}

	public Image getFile(String id) {
		return imageRepository.findById(id).get();
	}

	public Stream<Image> getAllFiles() {
		return imageRepository.findAll().stream();
	}
}
