package peerreview.controller;

import peerreview.service.ReviewAssignmentService;
import peerreview.util.InputHelper;

public class ReviewAssignmentController {

    private ReviewAssignmentService
            reviewService;

    public ReviewAssignmentController() {

        reviewService =
                new ReviewAssignmentService();
    }

    public void attribuerReviews() {

        System.out.println();

        System.out.println(
                "===== ATTRIBUTION REVIEWS ====="
        );

        reviewService
                .attribuerReviews();
    }

    public void afficherMesReviews(
            int evaluateurId
    ) {

        System.out.println();

        System.out.println(
                "===== MES EVALUATIONS ====="
        );

        reviewService
                .afficherMesReviews(
                        evaluateurId
                );
    }

    public void terminerReview() {

        int reviewId =
                InputHelper.lireInt(
                        "Review ID : "
                );

        reviewService
                .terminerReview(
                        reviewId
                );
    }
}