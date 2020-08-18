package com.hieulexuan.springjwt.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hieulexuan.springjwt.exceptions.UserNotFoundException;
import com.hieulexuan.springjwt.message.ResponsePermission;
import com.hieulexuan.springjwt.models.Permission;
import com.hieulexuan.springjwt.models.User;
import com.hieulexuan.springjwt.service.PermissionService;
import com.hieulexuan.springjwt.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PermissionController {

	@Autowired
	PermissionService permissionService;
		
	@Autowired
	UserService userService;

	@GetMapping("/permissions")
	public ResponseEntity<List<ResponsePermission>> getListPermissions() {
		List<ResponsePermission> permissions = permissionService.getAllPermissions().map(dbPermission -> {

			return new ResponsePermission(dbPermission.getId(), dbPermission.getName());
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(permissions);
	}

	@PutMapping("/permissions")
	public void setPermissions(@RequestParam("user_id") Long userid, @RequestParam("permission_id") Integer permissionid) {
		User user = userService.findById(userid)
				.orElseThrow(() -> new UserNotFoundException(String.valueOf(userid)));
		Permission permission = permissionService.findById(permissionid);
		
		user.getPermissions().add(permission);
		
		// save user
		userService.save(user);
	}
}
