package com.apoio.apoio_api.service;

import com.apoio.apoio_api.dto.evaluation.EvaluationRequest;
import com.apoio.apoio_api.entity.Evaluation;
import com.apoio.apoio_api.repository.EvaluationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EvaluationService {
    private final EvaluationRepository evaluationRepository;

    public EvaluationService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public Evaluation createEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    public Evaluation getEvaluationById(UUID id) {
        return evaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found"));
    }

    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    public Evaluation updateEvaluation(UUID id, EvaluationRequest evaluationDetails) {
        Evaluation evaluationFromDb = getEvaluationById(id);

        evaluationDetails.toEntityUpdate(evaluationFromDb);

        return evaluationRepository.save(evaluationFromDb);
    }

    public void deleteEvaluation(UUID id) {
        Evaluation evaluation = getEvaluationById(id);
        evaluationRepository.delete(evaluation);
    }
}
