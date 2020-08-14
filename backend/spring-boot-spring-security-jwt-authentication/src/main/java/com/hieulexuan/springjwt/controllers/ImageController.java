package com.hieulexuan.springjwt.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hieulexuan.springjwt.message.ResponseMessage;
import com.hieulexuan.springjwt.models.Image;
import com.hieulexuan.springjwt.service.ImageService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ImageController {

	@Autowired
	ImageService imageService;

	@PutMapping("image/{id}")
	public ResponseEntity<ResponseMessage> updateImage(@RequestBody Image image, @PathVariable String id) {
		String message = "";
		try {
			imageService.updateImage(image, id);
			message = "Uploaded image have " + id + "successfully! ";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (IOException e) {
			message = "Could not upload image have " + id +"!" ;
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

	@DeleteMapping("image/{id}")
	public void deleteImage(@PathVariable String id) {
		imageService.deleteImage(id);
	}
}
