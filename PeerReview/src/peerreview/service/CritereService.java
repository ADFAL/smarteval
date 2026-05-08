package peerreview.service;

import peerreview.dao.CritereDAO;
import peerreview.dao.CritereDAOImpl;
import peerreview.model.Critere;

import java.util.List;

public class CritereService {

    private CritereDAO critereDAO;

    public CritereService() {

        critereDAO =
                new CritereDAOImpl();
    }

    public void ajouterCritere(

            String nom,

            int noteMax,

            int assignmentId
    ) {

        Critere critere =
                new Critere();

        critere.setNom(nom);

        critere.setNoteMax(
                noteMax
        );

        critere.setAssignmentId(
                assignmentId
        );

        boolean result =
                critereDAO
                        .ajouterCritere(
                                critere
                        );

        if (result) {

            System.out.println(
                    "Critere ajoute avec succes."
            );

        } else {

            System.out.println(
                    "Erreur ajout critere."
            );
        }
    }

    public void afficherCriteres() {

        List<Critere> liste =
                critereDAO
                        .afficherCriteres();

        if (liste.isEmpty()) {

            System.out.println(
                    "Aucun critere."
            );

            return;
        }

        for (Critere critere : liste) {

            System.out.println(
                    "----------------"
            );

            System.out.println(
                    "ID : "
                            + critere.getId()
            );

            System.out.println(
                    "Nom : "
                            + critere.getNom()
            );

            System.out.println(
                    "Note max : "
                            + critere.getNoteMax()
            );

            System.out.println(
                    "Assignment ID : "
                            + critere.getAssignmentId()
            );
        }
    }

    public void supprimerCritere(
            int id
    ) {

        boolean result =
                critereDAO
                        .supprimerCritere(id);

        if (result) {

            System.out.println(
                    "Critere supprime."
            );

        } else {

            System.out.println(
                    "Erreur suppression."
            );
        }
    }
}