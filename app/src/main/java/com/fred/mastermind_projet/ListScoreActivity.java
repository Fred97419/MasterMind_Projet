package com.fred.mastermind_projet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * ListScoreActivity gère notre liste de score. En récupérant le nom et le score de ScoreActivity elle va les ajouter à
 * une base de donnée, mettre à jour celle ci et ajouter son contenu dans une List de Score.
 *
 * La ListView pourra ensuite utiliser cette List via un ArrayAdapter pour afficher notre liste de scores
 *
 *
 * @see ListScoreActivity
 * @see DatabaseHelper
 * @see ScoreArrayAdapter
 * @see Score
 *
 *
 *
 */
public class ListScoreActivity extends AppCompatActivity {

    private String chronoText; //score
    private String nomScore; //nom
    private ListView listViewScore; //
    private List<Score> scores; //Liste de score
    private ScoreArrayAdapter adapter;

    private DatabaseHelper scoreDB ; //notre base de donnée






    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_score);

        scoreDB = new DatabaseHelper(this);


        chronoText = "";
        nomScore = "";
        Intent intent = getIntent();
        if (intent != null) {

            chronoText = intent.getStringExtra("chronoText");
            nomScore = intent.getStringExtra("nomScore");
            System.out.println(chronoText);
            System.out.println(nomScore);


        }

        listViewScore = findViewById(R.id.listScore);



        Cursor data = scoreDB.getListContents();
        addData(chronoText,nomScore);

        scores = new ArrayList<Score>();


        if (data.getCount() != 0){


            /*Parcours toute la base de donnée pour rajouter chaque élément dans notre liste utilisable par l'ArrayAdapter*/
            while(data.moveToNext()){



                scores.add(new Score(data.getString(1) , data.getString(2)));

                adapter = new ScoreArrayAdapter(ListScoreActivity.this , scores);

                listViewScore.setAdapter(adapter);


            }

        }






    }

    /**
     *
     * Va ajouter notre nom et score à notre base de données
     *
     *
     * @param nom nom du joueur
     * @param score score du joueur
     */
    public void addData(String nom , String score){

        boolean insertData = scoreDB.addData(nom ,score);

        if (insertData){

            System.out.println("SUCCES : AJOUTER");
        }

        else{

            System.out.println("ECHEC : AJOUTER");
        }

    }

    public void quitter(View v){

        Intent home = new Intent(this,MainActivity.class);
        startActivity(home);

    }

}

