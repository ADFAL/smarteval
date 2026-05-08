package peerreview.dao;

import peerreview.model.Submission;

import java.util.List;

public interface SubmissionDAO {

    boolean ajouterSubmission(
            Submission submission
    );

    List<Submission>
    afficherSubmissions();

    boolean supprimerSubmission(
            int id
    );
}