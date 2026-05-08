package peerreview.dao;

import peerreview.database.ConnectionDatabase;
import peerreview.model.EvaluationDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EvaluationDetailDAOImpl
        implements EvaluationDetailDAO {

    @Override
    public boolean ajouterDetail(
            EvaluationDetail detail
    ) {

        Connection connection = null;

        PreparedStatement ps = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "INSERT INTO EvaluationDetails " +
                            "(note, evaluation_id, critere_id) " +
                            "VALUES (?, ?, ?)";

            ps =
                    connection.prepareStatement(sql);

            ps.setInt(
                    1,
                    detail.getNote()
            );

            ps.setInt(
                    2,
                    detail.getEvaluationId()
            );

            ps.setInt(
                    3,
                    detail.getCritereId()
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
    public List<EvaluationDetail>
    afficherDetails() {

        List<EvaluationDetail> liste =
                new ArrayList<>();

        Connection connection = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "SELECT * FROM EvaluationDetails";

            ps =
                    connection.prepareStatement(sql);

            rs =
                    ps.executeQuery();

            while (rs.next()) {

                EvaluationDetail detail =
                        new EvaluationDetail();

                detail.setId(
                        rs.getInt("id")
                );

                detail.setNote(
                        rs.getInt("note")
                );

                detail.setEvaluationId(
                        rs.getInt(
                                "evaluation_id"
                        )
                );

                detail.setCritereId(
                        rs.getInt(
                                "critere_id"
                        )
                );

                liste.add(detail);
            }

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }

        return liste;
    }

    @Override
    public List<EvaluationDetail>
    afficherDetailsParEvaluation(
            int evaluationId
    ) {

        List<EvaluationDetail> liste =
                new ArrayList<>();

        Connection connection = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {

            connection =
                    ConnectionDatabase
                            .getConnection();

            String sql =
                    "SELECT * FROM EvaluationDetails " +
                            "WHERE evaluation_id=?";

            ps =
                    connection.prepareStatement(sql);

            ps.setInt(
                    1,
                    evaluationId
            );

            rs =
                    ps.executeQuery();

            while (rs.next()) {

                EvaluationDetail detail =
                        new EvaluationDetail();

                detail.setId(
                        rs.getInt("id")
                );

                detail.setNote(
                        rs.getInt("note")
                );

                detail.setEvaluationId(
                        rs.getInt(
                                "evaluation_id"
                        )
                );

                detail.setCritereId(
                        rs.getInt(
                                "critere_id"
                        )
                );

                liste.add(detail);
            }

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }

        return liste;
    }
}