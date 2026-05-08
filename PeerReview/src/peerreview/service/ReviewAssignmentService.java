package peerreview.service;

import peerreview.dao.ReviewAssignmentDAO;
import peerreview.dao.ReviewAssignmentDAOImpl;
import peerreview.dao.SubmissionDAO;
import peerreview.dao.SubmissionDAOImpl;
import peerreview.model.ReviewAssignment;
import peerreview.model.Submission;

import java.util.Collections;
import java.util.List;

public class ReviewAssignmentService {

    private ReviewAssignmentDAO
            reviewDAO;

    private SubmissionDAO
            submissionDAO;

    public ReviewAssignmentService() {

        reviewDAO =
                new ReviewAssignmentDAOImpl();

        submissionDAO =
                new SubmissionDAOImpl();
    }

    public void attribuerReviews() {

        List<Submission> submissions =
                submissionDAO
                        .afficherSubmissions();

        if (submissions.size() < 2) {

            System.out.println(
                    "Pas assez de submissions."
            );

            return;
        }

        Collections.shuffle(
                submissions
        );

        for (Submission submission
                : submissions) {

            int compteur = 0;

            for (Submission autre
                    : submissions) {

                if (compteur == 2) {

                    break;
                }

                if (
                        submission.getEtudiantId()
                                != autre.getEtudiantId()
                ) {

                    ReviewAssignment review =
                            new ReviewAssignment();

                    review.setEvaluateurId(
                            submission.getEtudiantId()
                    );

                    review.setSubmissionId(
                            autre.getId()
                    );

                    reviewDAO
                            .ajouterReviewAssignment(
                                    review
                            );

                    compteur++;
                }
            }
        }

        System.out.println(
                "Attribution terminee."
        );
    }

    public void afficherMesReviews(
            int evaluateurId
    ) {

        List<ReviewAssignment> liste =
                reviewDAO
                        .afficherReviewsParEtudiant(
                                evaluateurId
                        );

        if (liste.isEmpty()) {

            System.out.println(
                    "Aucune review."
            );

            return;
        }

        for (ReviewAssignment review
                : liste) {

            System.out.println(
                    "----------------"
            );

            System.out.println(
                    "Review ID : "
                            + review.getId()
            );

            System.out.println(
                    "Submission ID : "
                            + review.getSubmissionId()
            );

            System.out.println(
                    "Deja fait : "
                            + review.isDejaFait()
            );
        }
    }

    public void terminerReview(
            int reviewId
    ) {

        boolean result =
                reviewDAO
                        .terminerReview(
                                reviewId
                        );

        if (result) {

            System.out.println(
                    "Evaluation terminee."
            );

        } else {

            System.out.println(
                    "Erreur."
            );
        }
    }
}