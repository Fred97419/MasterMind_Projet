package com.fred.mastermind_projet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.fred.mastermind_projet.Score;

import java.util.List;

public class ScoreArrayAdapter extends ArrayAdapter<Score> {



    public ScoreArrayAdapter(Context context , List<Score> scores){

        super(context , 0 , scores);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.score,parent, false);
        }

        TweetViewHolder viewHolder = (TweetViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new TweetViewHolder();
            viewHolder.nom = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.score = (TextView) convertView.findViewById(R.id.score);

            convertView.setTag(viewHolder);
        }

        
        Score score = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.score.setText(score.getTemps());
        viewHolder.nom.setText(score.getNom());


        return convertView;
    }

    private class TweetViewHolder{
        public TextView score;
        public TextView nom;

    }
}

