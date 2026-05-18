package com.apoio.apoio_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "evaluations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evaluation extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private int comfortScore;

    @Column(nullable = false)
    private int securityScore;

    @Column(nullable = false)
    private int lightningScore;

    @Column(nullable = false)
    private int accessibilityScore;

    @Column(nullable = false)
    private int furnitureScore;

    @Column(nullable = false, length = 1000)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "urban_project_id", nullable = false)
    private UrbanProject urbanProject;
}
