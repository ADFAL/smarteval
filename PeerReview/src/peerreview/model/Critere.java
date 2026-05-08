package peerreview.model;

public class Critere {

    private int id;

    private String nom;

    private int noteMax;

    private int assignmentId;

    public Critere() {

    }

    public Critere(

            int id,

            String nom,

            int noteMax,

            int assignmentId
    ) {

        this.id = id;

        this.nom = nom;

        this.noteMax = noteMax;

        this.assignmentId = assignmentId;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getNom() {

        return nom;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }

    public int getNoteMax() {

        return noteMax;
    }

    public void setNoteMax(int noteMax) {

        this.noteMax = noteMax;
    }

    public int getAssignmentId() {

        return assignmentId;
    }

    public void setAssignmentId(
            int assignmentId
    ) {

        this.assignmentId = assignmentId;
    }
}