package peerreview.controller;

import peerreview.service.CritereService;
import peerreview.util.InputHelper;

public class CritereController {

    private CritereService
            critereService;

    public CritereController() {

        critereService =
                new CritereService();
    }

    public void ajouterCritere() {

        System.out.println();

        System.out.println(
                "===== AJOUT CRITERE ====="
        );

        String nom =
                InputHelper.lireString(
                        "Nom critere : "
                );

        int noteMax =
                InputHelper.lireInt(
                        "Note maximale : "
                );

        int assignmentId =
                InputHelper.lireInt(
                        "Assignment ID : "
                );

        critereService
                .ajouterCritere(

                        nom,

                        noteMax,

                        assignmentId
                );
    }

    public void afficherCriteres() {

        System.out.println();

        System.out.println(
                "===== LISTE CRITERES ====="
        );

        critereService
                .afficherCriteres();
    }

    public void supprimerCritere() {

        int id =
                InputHelper.lireInt(
                        "ID Critere : "
                );

        critereService
                .supprimerCritere(id);
    }
}