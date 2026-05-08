package peerreview.dao;

import peerreview.model.Critere;

import java.util.List;

public interface CritereDAO {

    boolean ajouterCritere(
            Critere critere
    );

    List<Critere> afficherCriteres();

    boolean supprimerCritere(
            int id
    );
}