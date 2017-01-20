package com.wynsmaproject.www.yahtzee;

import android.widget.ImageView;

import java.net.URL;
import java.util.Random;

//import Runnable;

/**
 * Created by swynsma18 on 1/20/2017.
 * Die is an object on screen. It is runnable, and each die will be rolled to display an image w/ a value associated with it.
 */

public class Die implements Runnable{

    //static Image ourImage;
    static int imageWidth = 100, imageHeight = 100;
    private ImageView L;
    private int DieRoll;
    /**
     * Constructor for die. Takes a label and use it to display the picture.
     * @param ourL is the label being passed in.
     */
    public Die(ImageView ourL)
    {
        L = ourL;
    }
    @Override
    /**
     * This calls the thread for the die object. This function rolls the die, giving it a random number and picture.
     * First, it generates a random number of times the die will change, from 0 to 500.
     * Then, for each of these 0-500 iterations, it randomly generates the number and gives it an image based on the number generated.
     * For example, if "2" is rolled by the random number generator, an image of a "2" on a die will be shown.
     * At the end, the die will land on the value/image it has after the 0-500 iterations.
     */
    public void run() {
        Random Q = new Random();
        int S = Q.nextInt(100);
        for(int i = S; i >= 0; i--){
            Random R2 = new Random();
            int T = R2.nextInt(6);
            T += 1;
            //URL imgu;

            if (T == 1)
            {
                L.setImageResource(R.drawable.one);
            }
            else if(T == 2)
            {
                L.setImageResource(R.drawable.two);
            }
            else if(T == 3)
            {
                L.setImageResource(R.drawable.three);
            }
            else if(T == 4)
            {
                L.setImageResource(R.drawable.four);
            }
            else if(T == 5)
            {
                L.setImageResource(R.drawable.five);
            }
            else
            {
                L.setImageResource(R.drawable.six);
            }
            DieRoll = T;

//			try{
//				Thread.sleep(500);
//			}
//			catch (InterruptedException ex) {;}


        }
    }

    /**
     * Gets the number on the die.
     * @return the number on the die.
     */
    public int getInt()
    {
        return DieRoll;
    }

}
