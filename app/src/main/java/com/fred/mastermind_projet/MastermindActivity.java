package com.fred.mastermind_projet;

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
    private TableLayout grillePion;
    private TableLayout scorePion;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mastermind);
        grillePion = findViewById(R.id.grillePionMaster);
        scorePion = findViewById(R.id.scorePion);
        tabPion = new Button[11][4];
        setGrilleMastermind();



    }



    private void setGrilleMastermind(){


        //remplir la liste de pion noir

        for (int i = 0 ; i< 11 ; i++){

            for (int j = 0 ; j<4 ; j++){

                tabPion[i][j] = new Button(this);
                setColorPion(tabPion[i][j] , Color.GRAY);


            }


        }

        //grillePion.removeAllViews();
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT , TableRow.LayoutParams.WRAP_CONTENT);

        for (int i = 0 ; i<11 ; i++){
            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT , TableRow.LayoutParams.WRAP_CONTENT));

            for(int j = 0 ; j< 4 ; j++){


                tabPion[i][j] = new Button(this);
                setColorPion(tabPion[i][j] , Color.BLACK);
                tabPion[i][j].setLayoutParams(lp);
                row.addView(tabPion[i][j]);
            }

            grillePion.addView(row,lp);
        }

    }

    private void setColorPion(Button b , int backgroundColor){

        GradientDrawable pion = (GradientDrawable) getResources().getDrawable(R.drawable.pion).mutate();
        pion.setColor(backgroundColor);
        b.setBackground(pion);

    }
}
