package peerreview.service;

import peerreview.dao.EvaluationDetailDAO;
import peerreview.dao.EvaluationDetailDAOImpl;
import peerreview.model.EvaluationDetail;

import java.util.List;

public class EvaluationDetailService {

    private EvaluationDetailDAO
            detailDAO;

    public EvaluationDetailService() {

        detailDAO =
                new EvaluationDetailDAOImpl();
    }

    public void ajouterDetail(

            int note,

            int evaluationId,

            int critereId
    ) {

        EvaluationDetail detail =
                new EvaluationDetail();

        detail.setNote(note);

        detail.setEvaluationId(
                evaluationId
        );

        detail.setCritereId(
                critereId
        );

        boolean result =
                detailDAO
                        .ajouterDetail(
                                detail
                        );

        if (result) {

            System.out.println(
                    "Detail ajoute."
            );

        } else {

            System.out.println(
                    "Erreur ajout detail."
            );
        }
    }

    public void afficherDetails() {

        List<EvaluationDetail> liste =
                detailDAO
                        .afficherDetails();

        if (liste.isEmpty()) {

            System.out.println(
                    "Aucun detail."
            );

            return;
        }

        for (EvaluationDetail detail
                : liste) {

            System.out.println(
                    "----------------"
            );

            System.out.println(
                    "ID : "
                            + detail.getId()
            );

            System.out.println(
                    "Note : "
                            + detail.getNote()
            );

            System.out.println(
                    "Evaluation ID : "
                            + detail.getEvaluationId()
            );

            System.out.println(
                    "Critere ID : "
                            + detail.getCritereId()
            );
        }
    }
}