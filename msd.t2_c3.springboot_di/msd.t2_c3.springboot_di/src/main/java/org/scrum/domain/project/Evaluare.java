package org.scrum.domain.project;

public class Evaluare implements Comparable<Evaluare>{
    private Integer evaluareId;
    public enum TipEvaluare {
        TestTeoretic, TestPractic, Interviu
    }
    private Evaluare.TipEvaluare tipEvaluare;
    private String descriereEvaluare;


    public Integer getEvaluareId(){
        return evaluareId;
    }
    public void setEvaluareId(Integer evaluareId){
        this.evaluareId=evaluareId;
    }
    public String getDescriereEvaluare(){
        return descriereEvaluare;
    }
    public void setDescriereEvaluare(String descriereEvaluare){
        this.descriereEvaluare=descriereEvaluare;
    }
    public Evaluare.TipEvaluare getTipEvaluare() {
        return tipEvaluare;
    }

    public void setTipEvaluare(Evaluare.TipEvaluare tipEvaluare) {
        this.tipEvaluare = tipEvaluare;
    }

    @Override
    public int compareTo(Evaluare other) {
        if (this.equals(other))
            return 0;
        return this.getEvaluareId().compareTo(other.getEvaluareId());
    }

    public Evaluare(Integer evaluareId, String descriereEvaluare) {
        super();
        this.evaluareId = evaluareId;
        this.descriereEvaluare = descriereEvaluare;
    }
    public Evaluare(Integer evaluareId, String descriereEvaluare, TipEvaluare tipEvaluare) {
        super();
        this.evaluareId=evaluareId;
        this.descriereEvaluare=descriereEvaluare;
        this.tipEvaluare=tipEvaluare;
    }
    public Evaluare() {
        super();
    }
    public String toString() {
        return "\n\t\tEvaluare  [id=" + evaluareId + ", descriere evaluare=" + descriereEvaluare +"]";
    }
}
