package peerreview.dao;

import peerreview.database.ConnectionDatabase;
import peerreview.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean register(
            User user
    ) {

        Connection connection = null;

        PreparedStatement ps = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "INSERT INTO Users " +
                            "(nom, email, motDePasse, role) " +
                            "VALUES (?, ?, ?, ?)";

            ps =
                    connection.prepareStatement(sql);

            ps.setString(
                    1,
                    user.getNom()
            );

            ps.setString(
                    2,
                    user.getEmail()
            );

            ps.setString(
                    3,
                    user.getMotDePasse()
            );

            ps.setString(
                    4,
                    user.getRole()
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
    public User login(

            String email,

            String motDePasse
    ) {

        Connection connection = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "SELECT * FROM Users " +
                            "WHERE email=? " +
                            "AND motDePasse=?";

            ps =
                    connection.prepareStatement(sql);

            ps.setString(
                    1,
                    email
            );

            ps.setString(
                    2,
                    motDePasse
            );

            rs =
                    ps.executeQuery();

            if (rs.next()) {

                User user =
                        new User();

                user.setId(
                        rs.getInt("id")
                );

                user.setNom(
                        rs.getString("nom")
                );

                user.setEmail(
                        rs.getString("email")
                );

                user.setMotDePasse(
                        rs.getString(
                                "motDePasse"
                        )
                );

                user.setRole(
                        rs.getString("role")
                );

                return user;
            }

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }

        return null;
    }
}