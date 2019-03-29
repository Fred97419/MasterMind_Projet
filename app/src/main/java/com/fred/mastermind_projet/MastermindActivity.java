package com.fred.mastermind_projet;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MastermindActivity extends AppCompatActivity  {

    private int manche = 0 ;

    private Button[][] tabPion ;
    private Button[][] tabScore;
    private Button[] tabJouer; //nos 4 pions pour lesquels on va choisir la couleur
    private TableLayout grillePion;
    private TableLayout scorePion;

    private int[] couleurPionGrille = {Color.YELLOW, Color.CYAN , Color.MAGENTA , Color.GREEN , Color.RED, Color.BLACK, Color.BLUE };
    private int[] couleurPionScore = {Color.BLACK , Color.RED , Color.WHITE};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mastermind);
        grillePion = findViewById(R.id.grillePionMaster);
        scorePion = findViewById(R.id.scorePion);
        tabPion = new Button[11][4];
        tabScore = new Button[11][4];
        tabJouer = new Button[4];


        setGrilleMastermind();
        setScoreMastermind();
        setPionJouer();
    }

    private void setGrilleMastermind(){

        grillePion.removeAllViews();
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT , TableRow.LayoutParams.WRAP_CONTENT);
        lp.setMargins(15,5,15,5);

        for (int i = 0 ; i<11 ; i++){
            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT , TableRow.LayoutParams.WRAP_CONTENT));

            for(int j = 0 ; j< 4 ; j++){

                tabPion[i][j] = new Button(this);
                setColorPion(tabPion[i][j] , Color.DKGRAY);
                tabPion[i][j].setLayoutParams(lp);
                row.addView(tabPion[i][j]);
                tabPion[i][j].getLayoutParams().width = 100;
                tabPion[i][j].getLayoutParams().height = 100;

            }

            grillePion.addView(row,lp);
        }
    }

    private void setPionJouer (){

        tabJouer[0] = findViewById(R.id.pion0);
        tabJouer[1] = findViewById(R.id.pion1);
        tabJouer[2] = findViewById(R.id.pion2);
        tabJouer[3] = findViewById(R.id.pion3);

        for(int i =0 ; i<4 ; i++) {

            setColorPion(tabJouer[i] , Color.YELLOW);
        }

    }


    private void setScoreMastermind(){

        scorePion.removeAllViews();
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT , TableRow.LayoutParams.WRAP_CONTENT);
        lp.setMargins(5,25,5,25);

        for (int i = 0 ; i<11 ; i++){
            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT , TableRow.LayoutParams.WRAP_CONTENT));

            for(int j = 0 ; j< 4 ; j++){

                tabScore[i][j] = new Button(this);
                setColorPion(tabScore[i][j] , Color.DKGRAY);
                tabScore[i][j].setLayoutParams(lp);
                row.addView(tabScore[i][j]);
                tabScore[i][j].getLayoutParams().width = 60;
                tabScore[i][j].getLayoutParams().height = 60;

            }

            scorePion.addView(row,lp);
        }
    }

    private void setColorPion(Button b , int backgroundColor){

        GradientDrawable pion = (GradientDrawable) getResources().getDrawable(R.drawable.pion).mutate();
        pion.setColor(backgroundColor);
        b.setBackgroundDrawable(pion);
        b.setTextColor(backgroundColor);

    }

    public void changeColor(View v){


        Button b = (Button) v;
         int compteur = Integer.parseInt(b.getText().toString());


        setColorPion(b,couleurPionGrille[compteur%7]);

        compteur++;

        b.setText(Integer.toString(compteur));

    }

    public void jouerManche(View v){


        for (int i = 0 ; i<4 ; i++){

            setColorPion(tabPion[10-manche][i] , tabJouer[i].getPaint().getColor());


        }

        manche ++;

        if (manche == 11){

            System.exit(0);

        }

    }


    public boolean isWin (){



        return true;
    }



}
