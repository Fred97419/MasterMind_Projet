package com.fred.mastermind_projet;

import android.content.Intent;
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

/**
 *  MastermindActivity est l'activité "pillier" de l'application c'est dans celle-ci que se déroule le jeu, avec toutes ses fonctionalités.
 *  Comme l'intéraction avec l'utilisateur, la création de la grille du jeu, le système de score etc ...
 *
 * @author Frédérick Fabre Ferber
 *
 *
 *
 */

public class MastermindActivity extends AppCompatActivity  {



    private int manche = 0 ;


    private Chronometer scoreChrono; //widget d'android chronometre qui est notre score

    private Button[][] tabPion ;    // un tableau qui représente notre grille du score.
    private Button[][] tabScore;    // un tableau qui représente notre grille du jeu.
    private Button[] tabJouer;      //nos 4 pions pour lesquels on va choisir la couleur
    private TableLayout grillePion; //TableLayout où est affiché notre tableau tabScore
    private TableLayout scorePion;  //TabLayout où est affiché notre tableau tabScore

    private int[] combinaison ; //tableau où va être stockée la combinaison aléatoire à trouver.

    private long[] couleurPionGrille = {Color.YELLOW, Color.CYAN , Color.MAGENTA , Color.GREEN , Color.RED, Color.BLACK, Color.BLUE, Color.WHITE}; //tableau contenant toutes les couleurs du jeu.

    @Override

    /**
     *
     * Met en place toutes les composantes du jeu au lancement de l'activité
     *
     *
     *
     *
     *
     *
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mastermind);



        grillePion = findViewById(R.id.grillePionMaster);
        scoreChrono = findViewById(R.id.chrono);
        scorePion = findViewById(R.id.scorePion);
        tabPion = new Button[11][4];
        tabScore = new Button[11][4];
        tabJouer = new Button[4]; //tableau de 4 boutons un pour chaque pion que le joueur va selectionner
        combinaison = new int[4];



        setGrilleMastermind();
        setScoreMastermind();
        setPionJouer();
        setCombinaison();
        scoreChrono.start();


    }


    /**
     *
     * Créé la grille de pion en remplissant le tableau,
     * et l'ajoute dans la <b>TableRow</b>.
     *
     *
     *
     *
     *
     *
     *
     */
    private void setGrilleMastermind(){

        grillePion.removeAllViews(); //refresh le layout

        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT , TableRow.LayoutParams.WRAP_CONTENT);
        lp.setMargins(15,5,15,5);

        for (int i = 0 ; i<11 ; i++){
            TableRow row = new TableRow(this); //créé une nouvelle ligne
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT , TableRow.LayoutParams.WRAP_CONTENT));

            for(int j = 0 ; j< 4 ; j++){

                //rajoute 4 boutons dans la "row"

                tabPion[i][j] = new Button(this);
                setColorPion(tabPion[i][j] , Color.DKGRAY);
                tabPion[i][j].setLayoutParams(lp);
                row.addView(tabPion[i][j]);
                tabPion[i][j].getLayoutParams().width = 100;
                tabPion[i][j].getLayoutParams().height = 100;

            }

            grillePion.addView(row,lp); //rajoute la row au layout
        }
    }

    /**
     *
     * Remplit le tableau combinaison avec 4 couleurs générées aléatoirement parmis les couleurs du tableau <b>couleurPionGrille</b>
     *
     *
     *
     */
    private void setCombinaison(){

        Random r = new Random();

        System.out.println("COMBINAISON :");
        for (int i =0 ; i<4 ; i++){

            combinaison[i] = (int)couleurPionGrille[r.nextInt(8)];

            System.out.print(" : [ "+showCombinaison(combinaison[i])+"] , ");
            System.out.println("");


        }


    }


    /**
     *
     *  récupère les 4 pions du joueur et définit la couleur sur jaune
     *
     *
     *
     *
     *
     *
     */
    private void setPionJouer (){

        tabJouer[0] = findViewById(R.id.pion0);
        tabJouer[1] = findViewById(R.id.pion1);
        tabJouer[2] = findViewById(R.id.pion2);
        tabJouer[3] = findViewById(R.id.pion3);

        for(int i =0 ; i<4 ; i++) {

            setColorPion(tabJouer[i] , Color.YELLOW);
        }

    }

    /**
     * Créé la grille de pion d'arbitrage (10 x 4) en remplissant le tableau,
     *      * et l'ajoute dans la <b>TableRow</b>.
     *
     */
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


    /**
     * Va modifier la couleur du bouton et lui donnner la forme du <b>Drawable</b> de pion.xml
     *
     *
     * @param b le boutton sur lequel on va changer la couleur
     * @param backgroundColor la couleur
     *
     *
     * @see GradientDrawable
     *
     *
     *
     */
    private void setColorPion(Button b , int backgroundColor){

        GradientDrawable pion = (GradientDrawable) getResources().getDrawable(R.drawable.pion).mutate();
        pion.setColor(backgroundColor);
        b.setBackgroundDrawable(pion);
        b.setTextColor(backgroundColor);

    }


    /**
     *
     *Récupère la couleur du bouton
     *
     *
     * @param b le bouton sur lequel on souhaite récupérer la couleur
     * @return la couleur
     */
    private int getColorPion(Button b){

        return b.getPaint().getColor();
    }


    /**
     * Change la couleur du bouton chaque fois que l'on clique dessus
     *
     * @param v Vue
     */
    public void changeColor(View v){


        Button b = (Button) v;
         int compteur = Integer.parseInt(b.getText().toString());


        setColorPion(b,(int)couleurPionGrille[compteur%8]);


        compteur++;

        b.setText(Integer.toString(compteur));

    }

    /**
     * Bouton "valider" qui va prendre les 4 couleurs données par le joueur et les placer sur les
     * lignes correspondantes en fonction de la manche. Puis va arbitrer la manche.
     *
     * Si la combinaison a été trouvée on gagne et on passe à l'activité suivante.
     * @see ScoreActivity
     *
     * Si on arrive à la manche 11 on perd
     *
     * @param v Vue
     */
    public void jouerManche(View v){



        /*

        Parcours TEST

         */
        for (int i = 0 ; i<4 ; i++){

            setColorPion(tabPion[10-manche][i] , getColorPion(tabJouer[i]));
            System.out.println(" Couleur tableau JOUER : " +i+" : "+ showCombinaison(getColorPion(tabJouer[i])));
        }



        arbitrageManche();

        manche++;

        if (manche == 11){

            System.exit(0);

        }

        if (isWin()){

            Intent scoreActivity = new Intent(this ,ScoreActivity.class);
            scoreActivity.putExtra("scoreChrono" , scoreChrono.getText());
            System.out.println(scoreChrono.getText());
            startActivity(scoreActivity);

        }

    }

    /**
     *
     * Determine si la couleur du bouton est dans la combinaison
     *
     * @param b Bouton
     * @return vrai si la couleur est dans la combinaison sinon faux
     */
    private boolean isInCombinaison(Button b){

        for (int i=0 ; i<4 ; i++){

            if ( getColorPion(b) == combinaison[i]) {

                return true;
            }

        }

        return false;


    }

    private int countIsInCombinaison(Button b) {

        int c = 0;

        for (int i = 0; i < 4; i++) {

            if (getColorPion(b) == combinaison[i]) {

                c++;
            }

        }

        return c;

    }


    /**
     *
     * Va arbitrer la manche chaque fois que le joueur aura valider ses pions.
     *
     *
     */
    private void arbitrageManche(){

        for (int i =0 ; i< 4 ; i++){



            for (int j=0 ; j<4 ; j++) {

                if (isInCombinaison(tabJouer[i])) {


                    if ((getColorPion(tabJouer[i]) == combinaison[j]) && i==j ) { //si le pion est dans la combinaison et bien placé

                        setColorPion(tabScore[10 - manche][i], Color.BLACK);
                        break;


                    }

                    if ((getColorPion(tabJouer[i]) != combinaison[j]) ) { //si le pion est dans la combinaison mais mal placé


                        if (j==3 ) {
                            setColorPion(tabScore[10 - manche][i], Color.RED);
                            break;

                        }

                    }

                }

                if (!(isInCombinaison(tabJouer[i]))){ //si le pion n'est pas dans la combinaison

                    setColorPion(tabScore[10-manche][i] , Color.WHITE);

                }

            }
        }





    }

    /**
     * Determine la couleur à partir du numéro de la couleur.
     * Sert surtout pour la phase de test.
     *
     * @param color numéro de la couleur
     * @return la chaine de caractères correspondant à la couleur
     */
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
