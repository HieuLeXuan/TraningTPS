package com.hieulexuan.springjwt.security;

import java.io.Serializable;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.hieulexuan.springjwt.exceptions.UserNotFoundException;
import com.hieulexuan.springjwt.models.Permission;
import com.hieulexuan.springjwt.models.User;
import com.hieulexuan.springjwt.repository.UserRepository;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

	@Autowired
	private UserRepository userRepository;

	// hasPermission('images', 'upload')
	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		String username = authentication.getName();
		User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));

		Set<Permission> permissions = user.getPermissions();
		String permissionName = ((String) targetDomainObject) + "_" + ((String) permission);

		return false;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		return false;
	}

}
