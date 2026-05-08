package peerreview.service;

import peerreview.dao.AssignmentDAO;
import peerreview.dao.AssignmentDAOImpl;
import peerreview.model.Assignment;

import java.util.List;

public class AssignmentService {

    private AssignmentDAO assignmentDAO;

    public AssignmentService() {

        assignmentDAO =
                new AssignmentDAOImpl();
    }

    public void ajouterAssignment(

            String titre,

            String description,

            String dateLimite
    ) {

        Assignment assignment =
                new Assignment();

        assignment.setTitre(
                titre
        );

        assignment.setDescription(
                description
        );

        assignment.setDateLimite(
                dateLimite
        );

        boolean result =
                assignmentDAO
                        .ajouterAssignment(
                                assignment
                        );

        if (result) {

            System.out.println(
                    "Assignment ajoute avec succes."
            );

        } else {

            System.out.println(
                    "Erreur ajout assignment."
            );
        }
    }

    public void afficherAssignments() {

        List<Assignment> liste =
                assignmentDAO
                        .afficherAssignments();

        if (liste.isEmpty()) {

            System.out.println(
                    "Aucun assignment."
            );

            return;
        }

        for (Assignment assignment : liste) {

            System.out.println(
                    "----------------"
            );

            System.out.println(
                    "ID : "
                            + assignment.getId()
            );

            System.out.println(
                    "Titre : "
                            + assignment.getTitre()
            );

            System.out.println(
                    "Description : "
                            + assignment.getDescription()
            );

            System.out.println(
                    "Date limite : "
                            + assignment.getDateLimite()
            );
        }
    }

    public void supprimerAssignment(
            int id
    ) {

        boolean result =
                assignmentDAO
                        .supprimerAssignment(
                                id
                        );

        if (result) {

            System.out.println(
                    "Assignment supprime."
            );

        } else {

            System.out.println(
                    "Erreur suppression."
            );
        }
    }
}