package peerreview.dao;

import peerreview.database.ConnectionDatabase;
import peerreview.model.ReviewAssignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReviewAssignmentDAOImpl
        implements ReviewAssignmentDAO {

    @Override
    public boolean ajouterReviewAssignment(
            ReviewAssignment review
    ) {

        Connection connection = null;

        PreparedStatement ps = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "INSERT INTO ReviewAssignments " +
                            "(evaluateur_id, submission_id) " +
                            "VALUES (?, ?)";

            ps =
                    connection.prepareStatement(sql);

            ps.setInt(
                    1,
                    review.getEvaluateurId()
            );

            ps.setInt(
                    2,
                    review.getSubmissionId()
            );

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }

        return false;
    }

    @Override
    public List<ReviewAssignment>
    afficherReviews() {

        List<ReviewAssignment> liste =
                new ArrayList<>();

        Connection connection = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "SELECT * FROM ReviewAssignments";

            ps =
                    connection.prepareStatement(sql);

            rs =
                    ps.executeQuery();

            while (rs.next()) {

                ReviewAssignment review =
                        new ReviewAssignment();

                review.setId(
                        rs.getInt("id")
                );

                review.setEvaluateurId(
                        rs.getInt(
                                "evaluateur_id"
                        )
                );

                review.setSubmissionId(
                        rs.getInt(
                                "submission_id"
                        )
                );

                review.setDejaFait(
                        rs.getBoolean(
                                "dejaFait"
                        )
                );

                liste.add(review);
            }

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }

        return liste;
    }

    @Override
    public List<ReviewAssignment>
    afficherReviewsParEtudiant(
            int evaluateurId
    ) {

        List<ReviewAssignment> liste =
                new ArrayList<>();

        Connection connection = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "SELECT * FROM ReviewAssignments " +
                            "WHERE evaluateur_id=?";

            ps =
                    connection.prepareStatement(sql);

            ps.setInt(
                    1,
                    evaluateurId
            );

            rs =
                    ps.executeQuery();

            while (rs.next()) {

                ReviewAssignment review =
                        new ReviewAssignment();

                review.setId(
                        rs.getInt("id")
                );

                review.setEvaluateurId(
                        rs.getInt(
                                "evaluateur_id"
                        )
                );

                review.setSubmissionId(
                        rs.getInt(
                                "submission_id"
                        )
                );

                review.setDejaFait(
                        rs.getBoolean(
                                "dejaFait"
                        )
                );

                liste.add(review);
            }

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }

        return liste;
    }

    @Override
    public boolean terminerReview(
            int reviewId
    ) {

        Connection connection = null;

        PreparedStatement ps = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "UPDATE ReviewAssignments " +
                            "SET dejaFait=1 " +
                            "WHERE id=?";

            ps =
                    connection.prepareStatement(sql);

            ps.setInt(
                    1,
                    reviewId
            );

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }

        return false;
    }
}