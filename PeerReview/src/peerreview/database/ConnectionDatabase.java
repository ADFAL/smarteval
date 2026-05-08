package peerreview.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDatabase {

    private static final String URL =
            "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=PeerReview;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true";

    private static final String USER =
            "sa";

    private static final String PASSWORD =
            "firstone2025";

    public static Connection getConnection() {

        Connection connection = null;

        try {

            connection =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD
                    );

            System.out.println(
                    "Connexion SQL Server reussie."
            );

        } catch (Exception e) {

            System.out.println(
                    "Erreur connexion DB."
            );

            System.out.println(
                    e.getMessage()
            );
        }

        return connection;
    }
}