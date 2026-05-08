package peerreview.controller;

import peerreview.service.EvaluationDetailService;
import peerreview.util.InputHelper;

public class EvaluationDetailController {

    private EvaluationDetailService
            detailService;

    public EvaluationDetailController() {

        detailService =
                new EvaluationDetailService();
    }

    public void ajouterDetail() {

        System.out.println();

        System.out.println(
                "===== AJOUT DETAIL ====="
        );

        int note =
                InputHelper.lireInt(
                        "Note : "
                );

        int evaluationId =
                InputHelper.lireInt(
                        "Evaluation ID : "
                );

        int critereId =
                InputHelper.lireInt(
                        "Critere ID : "
                );

        detailService
                .ajouterDetail(

                        note,

                        evaluationId,

                        critereId
                );
    }

    public void afficherDetails() {

        System.out.println();

        System.out.println(
                "===== DETAILS EVALUATION ====="
        );

        detailService
                .afficherDetails();
    }
}