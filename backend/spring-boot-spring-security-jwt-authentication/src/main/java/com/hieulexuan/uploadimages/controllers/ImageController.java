package com.hieulexuan.uploadimages.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hieulexuan.uploadimages.message.ResponseImage;
import com.hieulexuan.uploadimages.message.ResponseMessage;
import com.hieulexuan.uploadimages.models.Image;
import com.hieulexuan.uploadimages.service.ImageService;

@RestController
public class ImageController {

	@Autowired(required = false)
	private ImageService imageService;

	@PreAuthorize("(hasRole('USER') or hasRole('ADMIN')) and hasPermission('images', 'see')")
	@GetMapping("/images")
	public ResponseEntity<List<ResponseImage>> getListFiles() {

		List<ResponseImage> images = imageService.getAllFiles().map(dbImage -> {
			String imageDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/")
					.path(dbImage.getId()).toUriString();

			return new ResponseImage(dbImage.getId(), dbImage.getName(), imageDownloadUri, dbImage.getData(),
					dbImage.getDescription(), dbImage.getType(), dbImage.getData().length, dbImage.getCreateDate());
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(images);
	}

	@PreAuthorize("(hasRole('USER') or hasRole('ADMIN')) and hasPermission('images', 'download')")
	@GetMapping("/images/{id}")
	public ResponseEntity<Resource> getFile(@PathVariable String id) {
		Image image = imageService.getFile(id);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(image.getType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getName() + "\"")
				.body(new ByteArrayResource(image.getData()));
	}

	@PreAuthorize("(hasRole('USER') or hasRole('ADMIN')) and hasPermission('images', 'upload')")
	@PostMapping("/images")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,
			@RequestParam String description, Principal principal) {
		String username = principal.getName();
		String message = "";
		try {
			imageService.store(file, description, username);

			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

	@PutMapping("/images/{id}")
	public ResponseEntity<ResponseMessage> updateImage(@RequestBody Image image, @PathVariable String id) {
		String message = "";
		try {
			imageService.updateImage(image, id);
			message = "Uploaded image have " + id + "successfully! ";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (IOException e) {
			message = "Could not upload image have " + id + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

	@DeleteMapping("/images/{id}")
	public void deleteImage(@PathVariable String id) throws IOException {
		imageService.deleteImage(id);
	}
}