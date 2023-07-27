package com.formation.blogapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Transient
    private String passwordConfirm;

    @Column(length = 150, nullable = false, unique = true)
    private String email;

    @OneToOne
    private ProfileEntity profile;

    @OneToMany(mappedBy = "user")
    private Collection<PostEntity> posts;

    @OneToMany(mappedBy = "user")
    private Collection<CommentEntity> comments;
}
