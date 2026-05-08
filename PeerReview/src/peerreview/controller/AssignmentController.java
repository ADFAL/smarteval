package peerreview.controller;

import peerreview.service.AssignmentService;
import peerreview.util.InputHelper;

public class AssignmentController {

    private AssignmentService
            assignmentService;

    public AssignmentController() {

        assignmentService =
                new AssignmentService();
    }

    public void ajouterAssignment() {

        System.out.println();

        System.out.println(
                "===== AJOUT ASSIGNMENT ====="
        );

        String titre =
                InputHelper.lireString(
                        "Titre : "
                );

        String description =
                InputHelper.lireString(
                        "Description : "
                );

        String dateLimite =
                InputHelper.lireString(
                        "Date limite (YYYY-MM-DD) : "
                );

        assignmentService
                .ajouterAssignment(

                        titre,

                        description,

                        dateLimite
                );
    }

    public void afficherAssignments() {

        System.out.println();

        System.out.println(
                "===== LISTE ASSIGNMENTS ====="
        );

        assignmentService
                .afficherAssignments();
    }

    public void supprimerAssignment() {

        int id =
                InputHelper.lireInt(
                        "ID Assignment : "
                );

        assignmentService
                .supprimerAssignment(id);
    }
}