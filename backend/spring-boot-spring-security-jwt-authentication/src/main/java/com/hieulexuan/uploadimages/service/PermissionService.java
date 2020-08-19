package com.hieulexuan.uploadimages.service;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieulexuan.uploadimages.models.Permission;
import com.hieulexuan.uploadimages.repository.PermissionRepository;
import com.hieulexuan.uploadimages.repository.UserRepository;

@Service
public class PermissionService {

	@Autowired
	PermissionRepository permissionRepository;

	@Autowired
	UserRepository userRepository;

	public Stream<Permission> getAllPermissions() {
		return permissionRepository.findAll().stream();
	}

	public Optional<Permission> findById(Long permissionid) {
		return permissionRepository.findById(permissionid);
	}
	
}
