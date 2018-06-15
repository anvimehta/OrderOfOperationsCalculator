package edu.purdue.mehta109.trialanderror;

import io.realm.RealmObject;

public class EquationModel extends RealmObject{

    private long numberID;
    private String eq;
    private String answer;

    public long getNumberID(){
        return numberID;
    }

    public void setNumberID(int numberID) {
        this.numberID = numberID;
    }

    public String getEquation(){
        return eq;
    }

    public void setEquation(String eq){
        this.eq = eq;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
