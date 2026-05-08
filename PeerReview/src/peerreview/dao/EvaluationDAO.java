package peerreview.dao;

import peerreview.model.Evaluation;

import java.util.List;

public interface EvaluationDAO {

    boolean ajouterEvaluation(
            Evaluation evaluation
    );

    List<Evaluation>
    afficherEvaluations();

    List<Evaluation>
    afficherEvaluationsParSubmission(
            int submissionId
    );
}