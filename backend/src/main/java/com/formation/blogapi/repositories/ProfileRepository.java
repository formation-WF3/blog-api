package com.formation.blogapi.repositories;

import com.formation.blogapi.entities.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer> {
}
