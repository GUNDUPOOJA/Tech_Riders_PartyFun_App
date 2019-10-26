package com.example.partyfun;

import java.util.ArrayList;

public class Model1 {
    public ArrayList<Truth> gettruthsarray() {
        return truthsarray;
    }

    //setter for arraylist
    public void settruthsarray(ArrayList<Truth> playersarray) {

        this.truthsarray = truthsarray;
    }

    //creating a class for words in recyclerview
    public static class Truth{
        public String truth;

        public Truth(String truth){
            this.truth = truth;

        }
    }


    private static Model1 my_Model = null;

    public static Model1 getModel() {
        if (my_Model == null) {
            my_Model = new Model1();
        }
        return my_Model;
    }

    private ArrayList<Truth> truthsarray=new ArrayList<Truth>();

    private Model1() {
        settruthsarray(new ArrayList<Truth>());
//        loadModel();
    }
}
