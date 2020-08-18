package com.hieulexuan.springjwt.service;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieulexuan.springjwt.models.Permission;
import com.hieulexuan.springjwt.repository.PermissionRepository;
import com.hieulexuan.springjwt.repository.UserRepository;

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
