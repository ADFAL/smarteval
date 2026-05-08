package peerreview.service;

import peerreview.dao.EvaluationDAO;
import peerreview.dao.EvaluationDAOImpl;
import peerreview.model.Evaluation;

import java.util.List;

public class EvaluationService {

    private EvaluationDAO
            evaluationDAO;

    public EvaluationService() {

        evaluationDAO =
                new EvaluationDAOImpl();
    }

    public void ajouterEvaluation(

            String commentaire,

            int evaluateurId,

            int submissionId
    ) {

        if (commentaire.length() < 50) {

            System.out.println(
                    "Commentaire minimum 50 caracteres."
            );

            return;
        }

        Evaluation evaluation =
                new Evaluation();

        evaluation.setCommentaire(
                commentaire
        );

        evaluation.setEvaluateurId(
                evaluateurId
        );

        evaluation.setSubmissionId(
                submissionId
        );

        boolean result =
                evaluationDAO
                        .ajouterEvaluation(
                                evaluation
                        );

        if (result) {

            System.out.println(
                    "Evaluation ajoutee."
            );

        } else {

            System.out.println(
                    "Erreur ajout evaluation."
            );
        }
    }

    public void afficherEvaluations() {

        List<Evaluation> liste =
                evaluationDAO
                        .afficherEvaluations();

        if (liste.isEmpty()) {

            System.out.println(
                    "Aucune evaluation."
            );

            return;
        }

        for (Evaluation evaluation
                : liste) {

            System.out.println(
                    "----------------"
            );

            System.out.println(
                    "ID : "
                            + evaluation.getId()
            );

            System.out.println(
                    "Commentaire : "
                            + evaluation.getCommentaire()
            );

            System.out.println(
                    "Date : "
                            + evaluation.getDateEvaluation()
            );

            System.out.println(
                    "Evaluateur ID : "
                            + evaluation.getEvaluateurId()
            );

            System.out.println(
                    "Submission ID : "
                            + evaluation.getSubmissionId()
            );
        }
    }
}