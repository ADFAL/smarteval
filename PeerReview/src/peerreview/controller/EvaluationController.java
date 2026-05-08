package peerreview.controller;

import peerreview.service.EvaluationService;
import peerreview.util.InputHelper;

public class EvaluationController {

    private EvaluationService
            evaluationService;

    public EvaluationController() {

        evaluationService =
                new EvaluationService();
    }

    public void ajouterEvaluation(
            int evaluateurId
    ) {

        System.out.println();

        System.out.println(
                "===== AJOUT EVALUATION ====="
        );

        String commentaire =
                InputHelper.lireString(
                        "Commentaire : "
                );

        int submissionId =
                InputHelper.lireInt(
                        "Submission ID : "
                );

        evaluationService
                .ajouterEvaluation(

                        commentaire,

                        evaluateurId,

                        submissionId
                );
    }

    public void afficherEvaluations() {

        System.out.println();

        System.out.println(
                "===== LISTE EVALUATIONS ====="
        );

        evaluationService
                .afficherEvaluations();
    }
}