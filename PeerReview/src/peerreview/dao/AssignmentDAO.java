package peerreview.dao;

import peerreview.model.Assignment;

import java.util.List;

public interface AssignmentDAO {

    boolean ajouterAssignment(
            Assignment assignment
    );

    List<Assignment> afficherAssignments();

    boolean supprimerAssignment(
            int id
    );
}