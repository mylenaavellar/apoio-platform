package com.apoio.apoio_api.dto.evaluation;

import com.apoio.apoio_api.entity.Evaluation;

import java.time.LocalDateTime;
import java.util.UUID;

public record EvaluationResponse(
    UUID id,
    int comfortScore,
    int securityScore,
    int lightningScore,
    int accessibilityScore,
    int furnitureScore,
    String comment,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    UUID userId,
    UUID urbanProjectId
) {
    public EvaluationResponse fromEntity(Evaluation evaluation) {
        return new EvaluationResponse(
            evaluation.getId(),
            evaluation.getComfortScore(),
            evaluation.getSecurityScore(),
            evaluation.getLightningScore(),
            evaluation.getAccessibilityScore(),
            evaluation.getFurnitureScore(),
            evaluation.getComment(),
            evaluation.getCreatedAt(),
            evaluation.getUpdatedAt(),
            evaluation.getUser().getId(),
            evaluation.getUrbanProject().getId()
        );
    }
}
