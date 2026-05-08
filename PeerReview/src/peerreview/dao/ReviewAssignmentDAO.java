package peerreview.dao;

import peerreview.model.ReviewAssignment;

import java.util.List;

public interface ReviewAssignmentDAO {

    boolean ajouterReviewAssignment(
            ReviewAssignment review
    );

    List<ReviewAssignment>
    afficherReviews();

    List<ReviewAssignment>
    afficherReviewsParEtudiant(
            int evaluateurId
    );

    boolean terminerReview(
            int reviewId
    );
}