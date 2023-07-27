package com.formation.blogapi.repositories;

import com.formation.blogapi.entities.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity, Integer> {
}
