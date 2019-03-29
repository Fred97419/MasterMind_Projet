package com.fred.mastermind_projet;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MastermindActivity extends AppCompatActivity {


    private Button[][] tabPion ;
    private Button[][] tabScore;
    private TableLayout grillePion;
    private TableLayout scorePion;

    private int[] couleurPionGrille = {};
    private int[] couleurPionScore = {};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mastermind);
        grillePion = findViewById(R.id.grillePionMaster);
        scorePion = findViewById(R.id.scorePion);
        tabPion = new Button[11][4];
        tabScore = new Button[11][4];

        setGrilleMastermind();
        setScoreMastermind();



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

    }
}
