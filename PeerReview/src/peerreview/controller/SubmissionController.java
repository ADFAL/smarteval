package peerreview.controller;

import peerreview.service.SubmissionService;
import peerreview.util.InputHelper;

public class SubmissionController {

    private SubmissionService
            submissionService;

    public SubmissionController() {

        submissionService =
                new SubmissionService();
    }

    public void ajouterSubmission(
            int etudiantId
    ) {

        System.out.println();

        System.out.println(
                "===== AJOUT SUBMISSION ====="
        );

        String fichierPDF =
                InputHelper.lireString(
                        "Nom fichier PDF : "
                );

        int assignmentId =
                InputHelper.lireInt(
                        "Assignment ID : "
                );

        submissionService
                .ajouterSubmission(

                        fichierPDF,

                        etudiantId,

                        assignmentId
                );
    }

    public void afficherSubmissions() {

        System.out.println();

        System.out.println(
                "===== LISTE SUBMISSIONS ====="
        );

        submissionService
                .afficherSubmissions();
    }

    public void supprimerSubmission() {

        int id =
                InputHelper.lireInt(
                        "ID Submission : "
                );

        submissionService
                .supprimerSubmission(id);
    }
}