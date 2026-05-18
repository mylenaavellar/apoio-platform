package com.apoio.apoio_api.controller;

import com.apoio.apoio_api.dto.evaluation.EvaluationRequest;
import com.apoio.apoio_api.dto.evaluation.EvaluationResponse;
import com.apoio.apoio_api.entity.Evaluation;
import com.apoio.apoio_api.service.EvaluationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/evaluations")
@Tag(name = "Evaluations")
public class EvaluationController {

    private final EvaluationService evaluationService;

    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PostMapping
    public ResponseEntity<EvaluationResponse> createEvaluation(@RequestBody EvaluationRequest request) {
        Evaluation evaluationEntity = request.toEntity();

        Evaluation createdEvaluation = evaluationService.createEvaluation(evaluationEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(EvaluationResponse.fromEntity(createdEvaluation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluationResponse> getEvaluationById(@PathVariable UUID id) {
        Evaluation evaluation = evaluationService.getEvaluationById(id);

        return ResponseEntity.ok(EvaluationResponse.fromEntity(evaluation));
    }

    @GetMapping
    public ResponseEntity<List<EvaluationResponse>> getAllEvaluations() {
        List<EvaluationResponse> responses = evaluationService.getAllEvaluations().stream()
                .map(EvaluationResponse::fromEntity)
                .toList();

        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvaluationResponse> updateEvaluation(@PathVariable UUID id, @RequestBody EvaluationRequest request) {
        Evaluation updatedEvaluation = evaluationService.updateEvaluation(id, request);

        return ResponseEntity.ok(EvaluationResponse.fromEntity(updatedEvaluation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable UUID id) {
        evaluationService.deleteEvaluation(id);

        return ResponseEntity.noContent().build();
    }
}
