package com.hieulexuan.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hieulexuan.springjwt.message.ResponseMessage;
import com.hieulexuan.springjwt.models.Image;
import com.hieulexuan.springjwt.repository.ImageRepository;
import com.hieulexuan.springjwt.service.FilesStorageService;

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

	@Autowired
	FilesStorageService storageService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			storageService.save(file);

			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

//	  @GetMapping("/files")
//	  public ResponseEntity<List<Image>> getListFiles() {
//	    List<Image> fileInfos = storageService.loadAll().map(path -> {
//	      String filename = path.getFileName().toString();
//	      String url = MvcUriComponentsBuilder
//	          .fromMethodName(UploadFileController.class, "getFile", path.getFileName().toString()).build().toString();
//
//	      return new Image(filename, url);
//	    }).collect(Collectors.toList());
//
//	    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
//	  }
//
//	  @GetMapping("/files/{filename:.+}")
//	  @ResponseBody
//	  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
//	    Resource file = storageService.load(filename);
//	    return ResponseEntity.ok()
//	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
//	  }

}
