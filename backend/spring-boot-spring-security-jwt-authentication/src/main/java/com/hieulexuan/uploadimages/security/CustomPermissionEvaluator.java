package com.hieulexuan.uploadimages.security;

import java.io.Serializable;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.hieulexuan.uploadimages.exceptions.UserNotFoundException;
import com.hieulexuan.uploadimages.models.Permission;
import com.hieulexuan.uploadimages.models.User;
import com.hieulexuan.uploadimages.repository.UserRepository;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

	@Autowired(required = false)
	private UserRepository userRepository;

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		String username = authentication.getName();
		User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));

		Set<Permission> permissions = user.getPermissions();

		String permissionName = ((String) targetDomainObject) + "_" + ((String) permission);
		
		for (Permission permission2 : permissions) {
			
			if(permission2.getName().equals(permissionName)) {
				return true;
			}
		}
		
		return false;

	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		return false;
	}

}
