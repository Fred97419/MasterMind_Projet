package com.fred.mastermind_projet;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreChrono;
    String chronoText;
    Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        scoreChrono = findViewById(R.id.scoreChronoText);
        valider = findViewById(R.id.valider_score);

        valider.setBackgroundColor(Color.CYAN);

        scoreChrono.setTextSize(45);
        scoreChrono.setGravity(Gravity.CENTER);
        scoreChrono.setTextColor(Color.CYAN);

        chronoText = "";
        Intent intent = getIntent();
        if (intent != null) {

            if (intent.hasExtra("scoreChrono")) {
                chronoText = intent.getStringExtra("scoreChrono");
                System.out.println(chronoText);
                scoreChrono.setText(chronoText);

            }
        }


    }

}
