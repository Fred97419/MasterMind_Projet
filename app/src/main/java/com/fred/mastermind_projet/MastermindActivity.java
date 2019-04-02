package com.fred.mastermind_projet;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Random;

public class MastermindActivity extends AppCompatActivity  {



    private int manche = 0 ;
    private int secondes =0;

    private Chronometer scoreChrono;

    private Button[][] tabPion ;
    private Button[][] tabScore;
    private Button[] tabJouer; //nos 4 pions pour lesquels on va choisir la couleur
    private TableLayout grillePion;
    private TableLayout scorePion;

    private int[] combinaison ;
    private long[] couleurPionGrille = {Color.YELLOW, Color.CYAN , Color.MAGENTA , Color.GREEN , Color.RED, Color.BLACK, Color.BLUE, Color.WHITE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mastermind);



        grillePion = findViewById(R.id.grillePionMaster);
        scoreChrono = findViewById(R.id.chrono);
        scorePion = findViewById(R.id.scorePion);
        tabPion = new Button[11][4];
        tabScore = new Button[11][4];
        tabJouer = new Button[4];
        combinaison = new int[4];



        setGrilleMastermind();
        setScoreMastermind();
        setPionJouer();
        setCombinaison();
        scoreChrono.start();


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

    private void setCombinaison(){

        Random r = new Random();

        System.out.println("COMBINAISON :");
        for (int i =0 ; i<4 ; i++){

            combinaison[i] = (int)couleurPionGrille[r.nextInt(8)];

            System.out.print(" : [ "+showCombinaison(combinaison[i])+"] , ");
            System.out.println("");


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

    private int getColorPion(Button b){

        return b.getPaint().getColor();
    }

    public void changeColor(View v){


        Button b = (Button) v;
         int compteur = Integer.parseInt(b.getText().toString());


        setColorPion(b,(int)couleurPionGrille[compteur%8]);


        compteur++;

        b.setText(Integer.toString(compteur));

    }

    public void jouerManche(View v){




        for (int i = 0 ; i<4 ; i++){

            setColorPion(tabPion[10-manche][i] , getColorPion(tabJouer[i]));
            System.out.println(" Couleur tableau JOUER : " +i+" : "+ showCombinaison(getColorPion(tabJouer[i])));
        }



        arbitrageManche();

        manche++;

        if (manche == 11){

            System.exit(0);

        }

        if (isWin()) System.exit(0);

    }

    private boolean isInCombinaison(Button b){

        for (int i=0 ; i<4 ; i++){

            if ( getColorPion(b) == combinaison[i]) {

                return true;
            }

        }

        return false;


    }

    private void arbitrageManche(){

        for (int i =0 ; i< 4 ; i++){



            for (int j=0 ; j<4 ; j++) {

                if (isInCombinaison(tabJouer[i])) {


                    if ((getColorPion(tabJouer[i]) == combinaison[j])  && i==j  ) {

                        setColorPion(tabScore[10 - manche][i], Color.BLACK);
                        break;

                    }

                    if ( !(isInCombinaison(tabJouer[i]))) setColorPion(tabScore[10-manche][i] , Color.WHITE);





                }

            }
        }





    }

    private String showCombinaison(int color){
        String scolor="";
        switch (color){
            case -256:
                scolor = "Jaune";
                break;

            case -16711681:
                scolor="Cyan";
                break;

            case -65281:
                scolor="Magenta";
                break;


            case -65536:
                scolor="Rouge";
                break;

            case -16711936:
                scolor="Vert";
                break;

            case -16777216:
                scolor="Noir";
                break;

            case -16776961:
                scolor="Bleu";
                break;

            case -1 :
                scolor="Blanc";
                break;
        }


        return scolor;

    }


    public boolean isWin (){

        for (int i=0 ; i< 4 ; i++){

            if (getColorPion(tabJouer[i]) !=  combinaison[i] ) {



                return false;
            }



        }

        scoreChrono.stop();


        return true;
    }



}
