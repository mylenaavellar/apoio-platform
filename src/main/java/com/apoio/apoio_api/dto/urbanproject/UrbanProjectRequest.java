package com.apoio.apoio_api.dto.urbanproject;

import com.apoio.apoio_api.entity.ProjectCategory;
import com.apoio.apoio_api.entity.UrbanProject;

import java.time.LocalDate;
import java.util.UUID;

public record UrbanProjectRequest(
    String name,
    ProjectCategory category,
    String department,
    LocalDate openingDate,
    double latitude,
    double longitude
) {
    public UrbanProject toEntity() {
        return toEntity(null);
    }

    public UrbanProject toEntity(UUID id) {
        UrbanProject project = new UrbanProject();
        project.setId(id);
        project.setName(name());
        project.setCategory(category());
        project.setDepartment(department());
        project.setOpeningDate(openingDate());
        project.setLatitude(latitude());
        project.setLongitude(longitude());

        return project;
    }
}