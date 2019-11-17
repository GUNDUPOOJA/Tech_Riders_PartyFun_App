package com.example.partyfun;

import java.util.ArrayList;

public class Model3 {
    public ArrayList<Score> getScoresarray() {
        return Scoresarray;
    }

    //setter for arraylist
    public void setScoresarray(ArrayList<Score> Scoresarray) {

        this.Scoresarray = Scoresarray;
    }

    //creating a class for words in recyclerview
    public static class Score {
        public String Score;

        public Score(String Score) {
            this.Score = Score;

        }


    }


    private static Model3 my_Model = null;

    public static Model3 getModel() {
        if (my_Model == null) {
            my_Model = new Model3();
        }
        return my_Model;
    }

    private ArrayList<Score> Scoresarray;


    public String  get_index_score(int index){
        return  Scoresarray.get(index).Score;
    }

    private Model3() {
        setScoresarray(new ArrayList<Score>());
//        loadModel();
    }


}
