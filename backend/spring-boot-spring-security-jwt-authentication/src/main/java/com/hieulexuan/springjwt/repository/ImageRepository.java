package com.hieulexuan.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hieulexuan.springjwt.models.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {

}
