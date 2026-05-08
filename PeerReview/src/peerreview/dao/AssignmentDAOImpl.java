package peerreview.dao;

import peerreview.database.ConnectionDatabase;
import peerreview.model.Assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AssignmentDAOImpl
        implements AssignmentDAO {

    @Override
    public boolean ajouterAssignment(
            Assignment assignment
    ) {

        Connection connection = null;

        PreparedStatement ps = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "INSERT INTO Assignments " +
                            "(titre, description, dateLimite) " +
                            "VALUES (?, ?, ?)";

            ps =
                    connection.prepareStatement(sql);

            ps.setString(
                    1,
                    assignment.getTitre()
            );

            ps.setString(
                    2,
                    assignment.getDescription()
            );

            ps.setString(
                    3,
                    assignment.getDateLimite()
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
    public List<Assignment>
    afficherAssignments() {

        List<Assignment> liste =
                new ArrayList<>();

        Connection connection = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "SELECT * FROM Assignments";

            ps =
                    connection.prepareStatement(sql);

            rs =
                    ps.executeQuery();

            while (rs.next()) {

                Assignment assignment =
                        new Assignment();

                assignment.setId(
                        rs.getInt("id")
                );

                assignment.setTitre(
                        rs.getString(
                                "titre"
                        )
                );

                assignment.setDescription(
                        rs.getString(
                                "description"
                        )
                );

                assignment.setDateLimite(
                        rs.getString(
                                "dateLimite"
                        )
                );

                liste.add(
                        assignment
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
    public boolean supprimerAssignment(
            int id
    ) {

        Connection connection = null;

        PreparedStatement ps = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "DELETE FROM Assignments " +
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