package peerreview.dao;

import peerreview.database.ConnectionDatabase;
import peerreview.model.Submission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubmissionDAOImpl
        implements SubmissionDAO {

    @Override
    public boolean ajouterSubmission(
            Submission submission
    ) {

        Connection connection = null;

        PreparedStatement ps = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "INSERT INTO Submissions " +
                            "(fichierPDF, etudiant_id, assignment_id) " +
                            "VALUES (?, ?, ?)";

            ps =
                    connection.prepareStatement(sql);

            ps.setString(
                    1,
                    submission.getFichierPDF()
            );

            ps.setInt(
                    2,
                    submission.getEtudiantId()
            );

            ps.setInt(
                    3,
                    submission.getAssignmentId()
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
    public List<Submission>
    afficherSubmissions() {

        List<Submission> liste =
                new ArrayList<>();

        Connection connection = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "SELECT * FROM Submissions";

            ps =
                    connection.prepareStatement(sql);

            rs =
                    ps.executeQuery();

            while (rs.next()) {

                Submission submission =
                        new Submission();

                submission.setId(
                        rs.getInt("id")
                );

                submission.setFichierPDF(
                        rs.getString(
                                "fichierPDF"
                        )
                );

                submission.setDateSubmission(
                        rs.getString(
                                "dateSubmission"
                        )
                );

                submission.setEtudiantId(
                        rs.getInt(
                                "etudiant_id"
                        )
                );

                submission.setAssignmentId(
                        rs.getInt(
                                "assignment_id"
                        )
                );

                liste.add(
                        submission
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
    public boolean supprimerSubmission(
            int id
    ) {

        Connection connection = null;

        PreparedStatement ps = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "DELETE FROM Submissions " +
                            "WHERE id=?";

            ps =
                    connection.prepareStatement(sql);

            ps.setInt(
                    1,
                    id
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