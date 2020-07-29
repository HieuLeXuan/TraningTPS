package com.hieulexuan.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hieulexuan.springjwt.models.Image;
import com.hieulexuan.springjwt.repository.ImageRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/load")
public class UploadFileController {

	@Autowired
	ImageRepository imageRepository;

	@GetMapping("/all")
	public List<Image> allImages() {
		List<Image> images = imageRepository.findAll();
		return images;
	}

}
