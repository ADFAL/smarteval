package peerreview.model;

public class Evaluation {

    private int id;

    private String commentaire;

    private String dateEvaluation;

    private int evaluateurId;

    private int submissionId;

    public Evaluation() {

    }

    public Evaluation(

            int id,

            String commentaire,

            String dateEvaluation,

            int evaluateurId,

            int submissionId
    ) {

        this.id = id;

        this.commentaire =
                commentaire;

        this.dateEvaluation =
                dateEvaluation;

        this.evaluateurId =
                evaluateurId;

        this.submissionId =
                submissionId;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getCommentaire() {

        return commentaire;
    }

    public void setCommentaire(
            String commentaire
    ) {

        this.commentaire =
                commentaire;
    }

    public String getDateEvaluation() {

        return dateEvaluation;
    }

    public void setDateEvaluation(
            String dateEvaluation
    ) {

        this.dateEvaluation =
                dateEvaluation;
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
}