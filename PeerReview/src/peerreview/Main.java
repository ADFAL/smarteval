package peerreview;

import peerreview.controller.*;
import peerreview.model.User;
import peerreview.util.InputHelper;
import peerreview.vue.Menu;

public class Main {

    public static void main(String[] args) {

        AuthController authController = new AuthController();
        AssignmentController assignmentController = new AssignmentController();
        CritereController critereController = new CritereController();
        SubmissionController submissionController = new SubmissionController();
        ReviewAssignmentController reviewController = new ReviewAssignmentController();
        EvaluationController evaluationController = new EvaluationController();
        EvaluationDetailController detailController = new EvaluationDetailController();

        boolean quitter = false;

        while (!quitter) {

            Menu.afficherMenuPrincipal();

            int choix =
                    InputHelper.lireInt(
                            "Choix : "
                    );

            switch (choix) {

                case 1:

                    User user =
                            authController.login();

                    if (user != null) {

                        if (
                                user.getRole()
                                        .equalsIgnoreCase(
                                                "ENSEIGNANT"
                                        )
                        ) {

                            boolean logout =
                                    false;

                            while (!logout) {

                                Menu
                                        .afficherMenuEnseignant();

                                int choixEns =
                                        InputHelper.lireInt(
                                                "Choix : "
                                        );

                                switch (choixEns) {

                                    case 1:

                                        assignmentController
                                                .ajouterAssignment();

                                        break;

                                    case 2:

                                        assignmentController
                                                .afficherAssignments();

                                        break;

                                    case 3:

                                        assignmentController
                                                .supprimerAssignment();

                                        break;

                                    case 4:

                                        critereController
                                                .ajouterCritere();

                                        break;

                                    case 5:

                                        critereController
                                                .afficherCriteres();

                                        break;

                                    case 6:

                                        critereController
                                                .supprimerCritere();

                                        break;

                                    case 7:

                                        reviewController
                                                .attribuerReviews();

                                        break;

                                    case 8:

                                        logout = true;

                                        break;

                                    default:

                                        System.out.println(
                                                "Choix invalide."
                                        );
                                }
                            }

                        } else {

                            boolean logout =
                                    false;

                            while (!logout) {

                                Menu
                                        .afficherMenuEtudiant();

                                int choixEtu =
                                        InputHelper.lireInt(
                                                "Choix : "
                                        );

                                switch (choixEtu) {

                                    case 1:

                                        assignmentController
                                                .afficherAssignments();

                                        break;

                                    case 2:

                                        submissionController
                                                .ajouterSubmission(
                                                        user.getId()
                                                );

                                        break;

                                    case 3:

                                        submissionController
                                                .afficherSubmissions();

                                        break;

                                    case 4:

                                        reviewController
                                                .afficherMesReviews(
                                                        user.getId()
                                                );

                                        break;

                                    case 5:

                                        evaluationController
                                                .ajouterEvaluation(
                                                        user.getId()
                                                );

                                        break;

                                    case 6:

                                        evaluationController
                                                .afficherEvaluations();

                                        break;

                                    case 7:

                                        detailController
                                                .ajouterDetail();

                                        break;

                                    case 8:

                                        detailController
                                                .afficherDetails();

                                        break;

                                    case 9:

                                        reviewController
                                                .terminerReview();

                                        break;

                                    case 10:

                                        logout = true;

                                        break;

                                    default:

                                        System.out.println(
                                                "Choix invalide."
                                        );
                                }
                            }
                        }
                    }

                    break;

                case 2:

                    authController.register();

                    break;

                case 0:

                    quitter = true;

                    System.out.println(
                            "Au revoir."
                    );

                    break;

                default:

                    System.out.println(
                            "Choix invalide."
                    );
            }
        }
    }
}