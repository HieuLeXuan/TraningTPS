package com.hieulexuan.springjwt.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieulexuan.springjwt.exceptions.IdNotFoundException;
import com.hieulexuan.springjwt.models.Image;
import com.hieulexuan.springjwt.repository.ImageRepository;

@Service
public class ImageService {

	@Autowired
	ImageRepository imageRepository;

	public Image updateImage(Image image, String id) throws IOException {

		Image currentImage = imageRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));

		currentImage.setDescription(image.getDescription());

		return imageRepository.save(currentImage);
	}
	
	public void deleteImage(String id) {
		imageRepository.deleteById(id);
	}
}
