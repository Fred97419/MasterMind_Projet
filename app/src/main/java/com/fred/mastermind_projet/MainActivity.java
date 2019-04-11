package com.fred.mastermind_projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * MainActivity est l'activité principale de l'application c'est elle qui va amener vers les autres activités
 *
 * @see MastermindActivity
 * @see ListScoreActivity
 *
 *
 * @author Frédérick Fabre Ferber
 *
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void jouer (View v){

        Intent jouerActivity = new Intent(this ,MastermindActivity.class);


        startActivity(jouerActivity);

    }

    public void regle (View v){

        Intent regleActivity = new Intent(this ,RegleActivity.class);


        startActivity(regleActivity);


    }

    public void score (View v){

        Intent scoreActivity = new Intent (this, ListScoreActivity.class);

        startActivity(scoreActivity);

    }
}


