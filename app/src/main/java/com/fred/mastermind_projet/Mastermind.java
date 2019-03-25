package com.fred.mastermind_projet;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.fred.mastermind_projet.Pion;

public class Mastermind extends View {

    private Paint paint = new Paint();
    private Boolean started = false;




    public Mastermind(Context context, AttributeSet attrs) {
        super(context, attrs);
        initJeu();

    }


    private void initJeu(){

        setBackgroundColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        started = true;



    }


    public void onDraw(Canvas c){

        int i,j;
        float radius = 50;

        paint.setColor(Color.BLACK);


        for (i = 0 ; i< 11 ; i++){

            for (j = 0 ; j <4 ; j++){


                c.drawCircle (120+(radius/2) *j*5 , 120+(radius/2) * i*5, radius , paint  );


            }

        }






    }








}
