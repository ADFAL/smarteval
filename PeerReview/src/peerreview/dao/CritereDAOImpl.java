package peerreview.dao;

import peerreview.database.ConnectionDatabase;
import peerreview.model.Critere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CritereDAOImpl
        implements CritereDAO {

    @Override
    public boolean ajouterCritere(
            Critere critere
    ) {

        Connection connection = null;

        PreparedStatement ps = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "INSERT INTO Criteres " +
                            "(nom, noteMax, assignment_id) " +
                            "VALUES (?, ?, ?)";

            ps =
                    connection.prepareStatement(sql);

            ps.setString(
                    1,
                    critere.getNom()
            );

            ps.setInt(
                    2,
                    critere.getNoteMax()
            );

            ps.setInt(
                    3,
                    critere.getAssignmentId()
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
    public List<Critere>
    afficherCriteres() {

        List<Critere> liste =
                new ArrayList<>();

        Connection connection = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "SELECT * FROM Criteres";

            ps =
                    connection.prepareStatement(sql);

            rs =
                    ps.executeQuery();

            while (rs.next()) {

                Critere critere =
                        new Critere();

                critere.setId(
                        rs.getInt("id")
                );

                critere.setNom(
                        rs.getString(
                                "nom"
                        )
                );

                critere.setNoteMax(
                        rs.getInt(
                                "noteMax"
                        )
                );

                critere.setAssignmentId(
                        rs.getInt(
                                "assignment_id"
                        )
                );

                liste.add(
                        critere
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
    public boolean supprimerCritere(
            int id
    ) {

        Connection connection = null;

        PreparedStatement ps = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "DELETE FROM Criteres " +
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