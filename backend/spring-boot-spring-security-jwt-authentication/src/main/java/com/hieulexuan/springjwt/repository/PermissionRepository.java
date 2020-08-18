package com.hieulexuan.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hieulexuan.springjwt.models.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>{

}
