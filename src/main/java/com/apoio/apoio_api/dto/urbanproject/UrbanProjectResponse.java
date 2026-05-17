package com.apoio.apoio_api.dto.urbanproject;

import com.apoio.apoio_api.entity.ProjectCategory;
import com.apoio.apoio_api.entity.UrbanProject;

import java.time.LocalDate;
import java.util.UUID;

public record UrbanProjectResponse(
    UUID id,
    String name,
    ProjectCategory category,
    String department,
    LocalDate openingDate,
    double latitude,
    double longitude
) {
    public static UrbanProjectResponse fromEntity(UrbanProject project) {
        return new UrbanProjectResponse(
            project.getId(),
            project.getName(),
            project.getCategory(),
            project.getDepartment(),
            project.getOpeningDate(),
            project.getLatitude(),
            project.getLongitude()
        );
    }
}
