package net.obviam.bt.Agent;

public class Personality_Composition {
    private int extroversion;
    private int agreeableness;
    private int neuroticism;
    private int openness;
    private int conscientiousness;

    public Personality_Composition(int extroversion, int agreeableness, int neuroticism, int openness, int conscientiousness) {
        this.extroversion = extroversion;
        this.agreeableness = agreeableness;
        this.neuroticism = neuroticism;
        this.openness = openness;
        this.conscientiousness = conscientiousness;
    }

    public int getExtroversion() {
        return extroversion;
    }

    public void setExtroversion(int extroversion) {
        this.extroversion = extroversion;
    }

    public int getAgreeableness() {
        return agreeableness;
    }

    public void setAgreeableness(int agreeableness) {
        this.agreeableness = agreeableness;
    }

    public int getNeuroticism() {
        return neuroticism;
    }

    public void setNeuroticism(int neuroticism) {
        this.neuroticism = neuroticism;
    }

    public int getOpenness() {
        return openness;
    }

    public void setOpenness(int openness) {
        this.openness = openness;
    }


    public int getConscientiousness() {
        return conscientiousness;
    }

    public void setConscientiousness(int conscientiousness) {
        this.conscientiousness = conscientiousness;
    }

    @Override
    public String toString() {
        return  "extroversion=" + this.extroversion +
                ", agreeableness=" + this.agreeableness +
                ", neurotic=" + this.neuroticism +
                ", openness=" + this.openness +
                ", conscientiousness=" + this.conscientiousness;
    }
}
