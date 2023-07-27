package com.formation.blogapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    // Pour que la base mette la date automatiquement au moment de la création
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime datePosted;

    @ManyToOne(optional = false) // Permet de mettre la colonne en non nullable
    private UserEntity user;

    @ManyToOne(optional = false)
    private PostEntity post;
}
