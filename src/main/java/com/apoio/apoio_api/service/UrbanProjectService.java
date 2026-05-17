package com.apoio.apoio_api.service;

import com.apoio.apoio_api.dto.urbanproject.UrbanProjectRequest;
import com.apoio.apoio_api.entity.UrbanProject;
import com.apoio.apoio_api.repository.UrbanProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UrbanProjectService {
    private final UrbanProjectRepository urbanProjectRepository;

    public UrbanProjectService(UrbanProjectRepository urbanProjectRepository) {
        this.urbanProjectRepository = urbanProjectRepository;
    }

    public UrbanProject createProject(UrbanProject project) {
        return urbanProjectRepository.save(project);
    }

    public UrbanProject getUrbanProjectById(UUID id) {
        return urbanProjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public List<UrbanProject> getAllUrbanProjects() {
        return urbanProjectRepository.findAll();
    }

    public UrbanProject updateUrbanProject(UUID id, UrbanProjectRequest projectDetails) {
        getUrbanProjectById(id);

        UrbanProject updatedProject = projectDetails.toEntity(id);

        return urbanProjectRepository.save(updatedProject);
    }

    public void deleteUrbanProject(UUID id) {
        UrbanProject project = getUrbanProjectById(id);
        urbanProjectRepository.delete(project);
    }

}
