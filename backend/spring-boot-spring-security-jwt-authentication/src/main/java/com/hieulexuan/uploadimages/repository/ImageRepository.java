package com.hieulexuan.uploadimages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hieulexuan.uploadimages.models.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {

}
