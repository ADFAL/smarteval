package peerreview.dao;

import peerreview.database.ConnectionDatabase;
import peerreview.model.Evaluation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EvaluationDAOImpl
        implements EvaluationDAO {

    @Override
    public boolean ajouterEvaluation(
            Evaluation evaluation
    ) {

        Connection connection = null;

        PreparedStatement ps = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "INSERT INTO Evaluations " +
                            "(commentaire, evaluateur_id, submission_id) " +
                            "VALUES (?, ?, ?)";

            ps =
                    connection.prepareStatement(sql);

            ps.setString(
                    1,
                    evaluation.getCommentaire()
            );

            ps.setInt(
                    2,
                    evaluation.getEvaluateurId()
            );

            ps.setInt(
                    3,
                    evaluation.getSubmissionId()
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
    public List<Evaluation>
    afficherEvaluations() {

        List<Evaluation> liste =
                new ArrayList<>();

        Connection connection = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "SELECT * FROM Evaluations";

            ps =
                    connection.prepareStatement(sql);

            rs =
                    ps.executeQuery();

            while (rs.next()) {

                Evaluation evaluation =
                        new Evaluation();

                evaluation.setId(
                        rs.getInt("id")
                );

                evaluation.setCommentaire(
                        rs.getString(
                                "commentaire"
                        )
                );

                evaluation.setDateEvaluation(
                        rs.getString(
                                "dateEvaluation"
                        )
                );

                evaluation.setEvaluateurId(
                        rs.getInt(
                                "evaluateur_id"
                        )
                );

                evaluation.setSubmissionId(
                        rs.getInt(
                                "submission_id"
                        )
                );

                liste.add(
                        evaluation
                );
            }

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }

        return liste;
    }

    @Override
    public List<Evaluation>
    afficherEvaluationsParSubmission(
            int submissionId
    ) {

        List<Evaluation> liste =
                new ArrayList<>();

        Connection connection = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "SELECT * FROM Evaluations " +
                            "WHERE submission_id=?";

            ps =
                    connection.prepareStatement(sql);

            ps.setInt(
                    1,
                    submissionId
            );

            rs =
                    ps.executeQuery();

            while (rs.next()) {

                Evaluation evaluation =
                        new Evaluation();

                evaluation.setId(
                        rs.getInt("id")
                );

                evaluation.setCommentaire(
                        rs.getString(
                                "commentaire"
                        )
                );

                evaluation.setDateEvaluation(
                        rs.getString(
                                "dateEvaluation"
                        )
                );

                evaluation.setEvaluateurId(
                        rs.getInt(
                                "evaluateur_id"
                        )
                );

                evaluation.setSubmissionId(
                        rs.getInt(
                                "submission_id"
                        )
                );

                liste.add(
                        evaluation
                );
            }

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }

        return liste;
    }
}