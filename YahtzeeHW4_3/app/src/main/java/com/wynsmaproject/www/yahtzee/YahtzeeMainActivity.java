package com.wynsmaproject.www.yahtzee;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

import java.net.URL;
import java.util.Random;

/**
 * Yahtzee project made by Samuel Wynsma on 1/20/2017.
 * This program rolls 5 dice and shows the final result on screen, plus their value added together.
 */
public class YahtzeeMainActivity extends AppCompatActivity {

    @Override
    /**
     * Standard create function for android where all the fun begins.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yahtzee_main);
        Button rollButton = (Button)findViewById(R.id.Roller);
        rollButton.setOnClickListener(new View.OnClickListener()
        {
            Die[] dice = new Die[5];

            /**
             * When the roll button is pressed, all the dice are rolled, then their value is calculated up and displayed on screen.
             * @param view
             */
            public void onClick(View view)
            {
                ImageView im = (ImageView)findViewById(R.id.DieOne);
                ImageView im2 = (ImageView)findViewById(R.id.DieTwo);
                ImageView im3 = (ImageView)findViewById(R.id.DieThree);
                ImageView im4 = (ImageView)findViewById(R.id.DieFour);
                ImageView im5 = (ImageView)findViewById(R.id.DieFive);
                dice[0] = new Die(im);
                dice[1] = new Die(im2);
                dice[2] = new Die(im3);
                dice[3] = new Die(im4);
                dice[4] = new Die(im5);
                for(int j = 0; j < 5; j++)
                {
                    dice[j].run();
                }
                TextView text = (TextView)findViewById(R.id.textView);
                int Roll = 0;
                for (int k = 0; k < 5; k++)
                {
                    Roll += dice[k].getInt();
                }
                text.setText(""+Roll);

            }
        });



    }
}


