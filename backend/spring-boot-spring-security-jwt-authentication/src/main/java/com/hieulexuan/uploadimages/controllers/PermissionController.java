package com.hieulexuan.uploadimages.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hieulexuan.uploadimages.exceptions.IdNotFoundException;
import com.hieulexuan.uploadimages.message.ResponseMessage;
import com.hieulexuan.uploadimages.message.ResponsePermission;
import com.hieulexuan.uploadimages.models.Permission;
import com.hieulexuan.uploadimages.models.User;
import com.hieulexuan.uploadimages.service.PermissionService;
import com.hieulexuan.uploadimages.service.UserService;

@RestController
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private UserService userService;

	@GetMapping("/permissions")
	public ResponseEntity<List<ResponsePermission>> getListPermissions() {
		List<ResponsePermission> permissions = permissionService.getAllPermissions().map(dbPermission -> {

			return new ResponsePermission(dbPermission.getId(), dbPermission.getName());
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(permissions);
	}

	@PostMapping("/permissions")
	public ResponseEntity<ResponseMessage> setPermissions(@RequestParam("user_id") Long userid, @RequestParam("permission_id") Long permissionid) {
		String message = "";
		
		User user = userService.findById(userid).orElseThrow(() -> new IdNotFoundException(userid));
		Permission permission = permissionService.findById(permissionid)
				.orElseThrow(() -> new IdNotFoundException(permissionid));
		user.getPermissions().add(permission);
		
		try {
			userService.save(user);
			message = "Set the permission successfully!";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not set the permission !";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
}
