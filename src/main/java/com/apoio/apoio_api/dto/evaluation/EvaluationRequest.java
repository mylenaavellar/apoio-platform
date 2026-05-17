package com.apoio.apoio_api.dto.evaluation;

import com.apoio.apoio_api.entity.Evaluation;

public record EvaluationRequest(
    int comfortScore,
    int securityScore,
    int lightningScore,
    int accessibilityScore,
    int furnitureScore,
    String comment
) {
    public Evaluation toEntity(){
        Evaluation evaluation = new Evaluation();
        evaluation.setComfortScore(evaluation.getComfortScore());
        evaluation.setSecurityScore(evaluation.getSecurityScore());
        evaluation.setLightningScore(evaluation.getLightningScore());
        evaluation.setAccessibilityScore(evaluation.getAccessibilityScore());
        evaluation.setFurnitureScore(furnitureScore());
        evaluation.setComment(evaluation.getComment());

        return evaluation;
    }

    public void toEntityUpdate(Evaluation evaluationFromDb) {
        evaluationFromDb.setComfortScore(comfortScore());
        evaluationFromDb.setSecurityScore(securityScore());
        evaluationFromDb.setLightningScore(lightningScore());
        evaluationFromDb.setAccessibilityScore(accessibilityScore());
        evaluationFromDb.setComment(comment());
    }
}
