package peerreview.service;

import peerreview.dao.SubmissionDAO;
import peerreview.dao.SubmissionDAOImpl;
import peerreview.model.Submission;

import java.util.List;

public class SubmissionService {

    private SubmissionDAO
            submissionDAO;

    public SubmissionService() {

        submissionDAO =
                new SubmissionDAOImpl();
    }

    public void ajouterSubmission(

            String fichierPDF,

            int etudiantId,

            int assignmentId
    ) {

        Submission submission =
                new Submission();

        submission.setFichierPDF(
                fichierPDF
        );

        submission.setEtudiantId(
                etudiantId
        );

        submission.setAssignmentId(
                assignmentId
        );

        boolean result =
                submissionDAO
                        .ajouterSubmission(
                                submission
                        );

        if (result) {

            System.out.println(
                    "Submission ajoutee."
            );

        } else {

            System.out.println(
                    "Erreur ajout submission."
            );
        }
    }

    public void afficherSubmissions() {

        List<Submission> liste =
                submissionDAO
                        .afficherSubmissions();

        if (liste.isEmpty()) {

            System.out.println(
                    "Aucune submission."
            );

            return;
        }

        for (Submission submission : liste) {

            System.out.println(
                    "----------------"
            );

            System.out.println(
                    "ID : "
                            + submission.getId()
            );

            System.out.println(
                    "PDF : "
                            + submission.getFichierPDF()
            );

            System.out.println(
                    "Date : "
                            + submission.getDateSubmission()
            );

            System.out.println(
                    "Etudiant ID : "
                            + submission.getEtudiantId()
            );

            System.out.println(
                    "Assignment ID : "
                            + submission.getAssignmentId()
            );
        }
    }

    public void supprimerSubmission(
            int id
    ) {

        boolean result =
                submissionDAO
                        .supprimerSubmission(id);

        if (result) {

            System.out.println(
                    "Submission supprimee."
            );

        } else {

            System.out.println(
                    "Erreur suppression."
            );
        }
    }
}