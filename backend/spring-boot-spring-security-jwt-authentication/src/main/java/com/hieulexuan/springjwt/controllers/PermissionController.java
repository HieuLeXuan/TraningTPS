package com.hieulexuan.springjwt.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hieulexuan.springjwt.message.ResponsePermission;
import com.hieulexuan.springjwt.service.PermissionService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PermissionController {

	@Autowired
	PermissionService permissionService;

	// get list permission
	@GetMapping("/permissions")
	public ResponseEntity<List<ResponsePermission>> getListPermissions() {
		List<ResponsePermission> permissions = permissionService.getAllPermissions().map(dbPermission -> {

			return new ResponsePermission(dbPermission.getId(), dbPermission.getName());
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(permissions);
	}
	
}
