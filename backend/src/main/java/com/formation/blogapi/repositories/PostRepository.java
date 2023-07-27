package com.formation.blogapi.repositories;

import com.formation.blogapi.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<CommentEntity, Integer> {
}
