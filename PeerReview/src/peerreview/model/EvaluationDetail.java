package peerreview.model;

public class EvaluationDetail {

    private int id;

    private int note;

    private int evaluationId;

    private int critereId;

    public EvaluationDetail() {

    }

    public EvaluationDetail(

            int id,

            int note,

            int evaluationId,

            int critereId
    ) {

        this.id = id;

        this.note = note;

        this.evaluationId =
                evaluationId;

        this.critereId =
                critereId;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getNote() {

        return note;
    }

    public void setNote(int note) {

        this.note = note;
    }

    public int getEvaluationId() {

        return evaluationId;
    }

    public void setEvaluationId(
            int evaluationId
    ) {

        this.evaluationId =
                evaluationId;
    }

    public int getCritereId() {

        return critereId;
    }

    public void setCritereId(
            int critereId
    ) {

        this.critereId =
                critereId;
    }
}