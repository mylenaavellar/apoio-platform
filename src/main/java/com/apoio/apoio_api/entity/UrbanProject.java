package com.apoio.apoio_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "urban_projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UrbanProject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProjectCategory category;

    @Column(nullable = false, length = 100)
    private String department;

    @Column(nullable = false)
    private LocalDate openingDate;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;
}
