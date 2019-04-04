package com.fred.mastermind_projet;

public class Score {

    String temps;
    String nom;

    public Score (String temps , String nom){

        this.temps= temps;
        this.nom = nom;


    }

    public String getTemps(){

        return this.temps;
    }

    public String getNom(){

        return this.nom;
    }
}
