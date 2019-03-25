package com.fred.mastermind_projet;

import android.graphics.Color;

public class Pion {


    private int[] tabCouleur = {Color.CYAN , Color.YELLOW , Color.RED , Color.GREEN , Color.WHITE , Color.BLACK };

    protected Color color;


    public Pion (Color Color){

        this.color = color;

    }

    public Color getColor(){return color;}

    public float getRadius(){return 50;}






}
