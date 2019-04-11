package com.fred.mastermind_projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regle);
    }

    public void quitter(View v){

        Intent jouerActivity = new Intent(this ,MainActivity.class);


        startActivity(jouerActivity);

    }
}
