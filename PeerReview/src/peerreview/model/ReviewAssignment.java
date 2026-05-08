package peerreview.model;

public class ReviewAssignment {

    private int id;

    private int evaluateurId;

    private int submissionId;

    private boolean dejaFait;

    public ReviewAssignment() {

    }

    public ReviewAssignment(

            int id,

            int evaluateurId,

            int submissionId,

            boolean dejaFait
    ) {

        this.id = id;

        this.evaluateurId =
                evaluateurId;

        this.submissionId =
                submissionId;

        this.dejaFait =
                dejaFait;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getEvaluateurId() {

        return evaluateurId;
    }

    public void setEvaluateurId(
            int evaluateurId
    ) {

        this.evaluateurId =
                evaluateurId;
    }

    public int getSubmissionId() {

        return submissionId;
    }

    public void setSubmissionId(
            int submissionId
    ) {

        this.submissionId =
                submissionId;
    }

    public boolean isDejaFait() {

        return dejaFait;
    }

    public void setDejaFait(
            boolean dejaFait
    ) {

        this.dejaFait =
                dejaFait;
    }
}