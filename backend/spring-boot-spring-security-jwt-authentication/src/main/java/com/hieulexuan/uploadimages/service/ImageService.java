package com.hieulexuan.uploadimages.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hieulexuan.uploadimages.exceptions.IdNotFoundException;
import com.hieulexuan.uploadimages.exceptions.UserNotFoundException;
import com.hieulexuan.uploadimages.models.Image;
import com.hieulexuan.uploadimages.models.User;
import com.hieulexuan.uploadimages.repository.ImageRepository;
import com.hieulexuan.uploadimages.repository.UserRepository;

@Service
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	private UserRepository userRepository;

	private final Path root = Paths.get("uploads");

	public void init() {
		try {
			Files.createDirectories(root);
		} catch (Exception e) {
			throw new RuntimeException("Could not initialize folder for upload!");
		}
	}

	public Image store(MultipartFile file, String description, String username) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		java.util.Date date = new java.util.Date();

		User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));

		Image image = new Image(fileName, file.getContentType(), file.getBytes(), description, date, root.toString(),
				user);

		Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
		return imageRepository.save(image);
	}

	public Image getFile(String id) {
		return imageRepository.findById(id).get();
	}

	public Stream<Image> getAllFiles() {
		return imageRepository.findAll().stream();
	}

	public Image updateImage(Image image, String id) throws IOException {

		Image currentImage = imageRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));

		currentImage.setDescription(image.getDescription());

		return imageRepository.save(currentImage);
	}

	public void deleteImage(String id) throws IOException {
		imageRepository.deleteById(id);
	}
}
