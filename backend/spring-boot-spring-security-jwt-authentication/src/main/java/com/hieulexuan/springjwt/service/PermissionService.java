package com.hieulexuan.springjwt.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieulexuan.springjwt.models.Permission;
import com.hieulexuan.springjwt.repository.PermissionRepository;

@Service
public class PermissionService {

	@Autowired
	PermissionRepository permissionRepository;

	public Stream<Permission> getAllPermissions() {
		return permissionRepository.findAll().stream();
	}
}
