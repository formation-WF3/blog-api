package com.formation.blogapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    // @Temporal(TemporalType.DATE)
    private LocalDateTime datePosted;

    @ManyToOne(optional = false)
    private UserEntity user;

    @OneToMany(mappedBy = "post")
    private Collection<CommentEntity> comments;

    @ManyToMany
    // Si l'on veut personnaliser la table de jointure, ici pas vraiment besoin
    @JoinTable(
        name = "post_tag",
        joinColumns = @JoinColumn(name = "post_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Collection<TagEntity> tags;
}
