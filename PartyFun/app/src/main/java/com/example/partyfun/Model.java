package com.example.partyfun;

import java.util.ArrayList;

public class Model {

    public ArrayList<Player> getPlayersarray() {
        return playersarray;
    }

    //setter for arraylist
    public void setPlayersarray(ArrayList<Player> playersarray) {

        this.playersarray = playersarray;
    }

    //creating a class for words in recyclerview
    public static class Player {
        public String player;

        public Player(String player) {
            this.player = player;

        }
    }


    private static Model my_Model = null;

    public static Model getModel() {
        if (my_Model == null) {
            my_Model = new Model();
        }
        return my_Model;
    }

    private ArrayList<Player> playersarray;

    private Model() {
        setPlayersarray(new ArrayList<Player>());
//        loadModel();
    }
}