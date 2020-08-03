package com.hieulexuan.springjwt.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hieulexuan.springjwt.models.Image;
import com.hieulexuan.springjwt.repository.ImageRepository;

@Service
public class FileStorageService {

	@Autowired
	private ImageRepository imageRepository;

	public Image store(MultipartFile file, String description) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		java.util.Date date = new java.util.Date();
		Image image = new Image(fileName, file.getContentType(), file.getBytes(), description, date);
		
		return imageRepository.save(image);
	}

	public Image getFile(String id) {
		return imageRepository.findById(id).get();
	}

	public Stream<Image> getAllFiles() {
		return imageRepository.findAll().stream();
	}
}
