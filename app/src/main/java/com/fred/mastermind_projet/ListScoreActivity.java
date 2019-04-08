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

public class ListScoreActivity extends AppCompatActivity {

    private String chronoText;
    private String nomScore;
    private ListView listViewScore;
    private List<Score> scores;
    private ScoreArrayAdapter adapter;

    private DatabaseHelper scoreDB ;






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



            while(data.moveToNext()){



                scores.add(new Score(data.getString(1) , data.getString(2)));

                adapter = new ScoreArrayAdapter(ListScoreActivity.this , scores);

                listViewScore.setAdapter(adapter);


            }

        }






    }


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

