package peerreview.model;

public class Assignment {

    private int id;

    private String titre;

    private String description;

    private String dateLimite;

    public Assignment() {

    }

    public Assignment(

            int id,

            String titre,

            String description,

            String dateLimite
    ) {

        this.id = id;

        this.titre = titre;

        this.description = description;

        this.dateLimite = dateLimite;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getTitre() {

        return titre;
    }

    public void setTitre(String titre) {

        this.titre = titre;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(
            String description
    ) {

        this.description = description;
    }

    public String getDateLimite() {

        return dateLimite;
    }

    public void setDateLimite(
            String dateLimite
    ) {

        this.dateLimite = dateLimite;
    }
}