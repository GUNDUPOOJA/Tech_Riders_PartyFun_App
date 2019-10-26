package com.example.partyfun;

import java.util.ArrayList;

public class Model2 {
    public ArrayList<Dare> getdaresArray() {
        return daresArray;
    }

    //setter for arraylist
    public void setdaresArray(ArrayList<Dare> daresArray) {

        this.daresArray = daresArray;
    }

    //creating a class for words in recyclerview
    public static class Dare{
        public String Dare;

        public Dare(String Dare){
            this.Dare = Dare;

        }
    }


    private static Model2 my_Model = null;

    public static Model2 getModel() {
        if (my_Model == null) {
            my_Model = new Model2();
        }
        return my_Model;
    }

    private ArrayList<Dare> daresArray=new ArrayList<Dare>();

    private Model2() {
        setdaresArray(new ArrayList<Dare>());
//        loadModel();
    }


}
