package peerreview.dao;

import peerreview.model.EvaluationDetail;

import java.util.List;

public interface EvaluationDetailDAO {

    boolean ajouterDetail(
            EvaluationDetail detail
    );

    List<EvaluationDetail>
    afficherDetails();

    List<EvaluationDetail>
    afficherDetailsParEvaluation(
            int evaluationId
    );
}