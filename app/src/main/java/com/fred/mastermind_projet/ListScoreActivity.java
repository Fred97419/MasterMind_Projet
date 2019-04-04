package com.fred.mastermind_projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListScoreActivity extends AppCompatActivity {

    private String chronoText;
    private String nomScore;
    private ListView listViewScore;
    private List<Score> scores;
    ScoreArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_score);

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
        scores = new ArrayList<Score>();
        scores.add(new Score(chronoText , nomScore));

        adapter = new ScoreArrayAdapter(ListScoreActivity.this , scores);

        listViewScore.setAdapter(adapter);




    }

}

