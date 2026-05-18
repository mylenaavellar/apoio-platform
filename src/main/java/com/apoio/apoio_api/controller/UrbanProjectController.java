package com.apoio.apoio_api.controller;

import com.apoio.apoio_api.dto.urbanproject.UrbanProjectRequest;
import com.apoio.apoio_api.dto.urbanproject.UrbanProjectResponse;
import com.apoio.apoio_api.entity.UrbanProject;
import com.apoio.apoio_api.service.UrbanProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/urban-projects")
public class UrbanProjectController {

    private final UrbanProjectService urbanProjectService;

    public UrbanProjectController(UrbanProjectService urbanProjectService) {
        this.urbanProjectService = urbanProjectService;
    }

    @PostMapping
    public ResponseEntity<UrbanProjectResponse> createUrbanProject(@RequestBody UrbanProjectRequest request) {
        UrbanProject projectEntity = request.toEntity();

        UrbanProject createdProject = urbanProjectService.createProject(projectEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(UrbanProjectResponse.fromEntity(createdProject));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UrbanProjectResponse> getUrbanProject(@PathVariable UUID id) {
        UrbanProject project = urbanProjectService.getUrbanProjectById(id);

        return ResponseEntity.ok(UrbanProjectResponse.fromEntity(project));
    }

    @GetMapping
    public ResponseEntity<List<UrbanProjectResponse>> getAllUrbanProjects() {
        List<UrbanProjectResponse> responses = urbanProjectService.getAllUrbanProjects().stream()
                .map(UrbanProjectResponse::fromEntity)
                .toList();

        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UrbanProjectResponse> updateUrbanProject(@PathVariable UUID id, UrbanProjectRequest request) {
        UrbanProject updatedProject = urbanProjectService.updateUrbanProject(id, request);

        return ResponseEntity.ok(UrbanProjectResponse.fromEntity(updatedProject));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUrbanProject(@PathVariable UUID id) {

        urbanProjectService.deleteUrbanProject(id);

        return ResponseEntity.noContent().build();
    }
}
