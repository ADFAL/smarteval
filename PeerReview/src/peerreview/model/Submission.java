package peerreview.model;

public class Submission {

    private int id;

    private String fichierPDF;

    private String dateSubmission;

    private int etudiantId;

    private int assignmentId;

    public Submission() {

    }

    public Submission(

            int id,

            String fichierPDF,

            String dateSubmission,

            int etudiantId,

            int assignmentId
    ) {

        this.id = id;

        this.fichierPDF = fichierPDF;

        this.dateSubmission =
                dateSubmission;

        this.etudiantId =
                etudiantId;

        this.assignmentId =
                assignmentId;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getFichierPDF() {

        return fichierPDF;
    }

    public void setFichierPDF(
            String fichierPDF
    ) {

        this.fichierPDF =
                fichierPDF;
    }

    public String getDateSubmission() {

        return dateSubmission;
    }

    public void setDateSubmission(
            String dateSubmission
    ) {

        this.dateSubmission =
                dateSubmission;
    }

    public int getEtudiantId() {

        return etudiantId;
    }

    public void setEtudiantId(
            int etudiantId
    ) {

        this.etudiantId =
                etudiantId;
    }

    public int getAssignmentId() {

        return assignmentId;
    }

    public void setAssignmentId(
            int assignmentId
    ) {

        this.assignmentId =
                assignmentId;
    }
}