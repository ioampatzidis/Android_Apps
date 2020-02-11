package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    public void play(View view){

        Button butNew = (Button) findViewById(R.id.playagain);
        butNew.setVisibility(View.INVISIBLE);
        for (int i= 0 ; i<9; i++){

            gameState[i] = 2;
            int activeplayer = 0;

        }

        GridLayout gridLay = (GridLayout) findViewById(R.id.gridLayout2);

        for ( int k = 0; k < gridLay.getChildCount(); k++){
            ((ImageView) gridLay.getChildAt(k)).setImageResource(0);


        }
        TextView butP1 = (TextView) findViewById(R.id.player1);
        TextView butP2 = (TextView) findViewById(R.id.player2);
        butP2.setBackgroundColor(Color.parseColor("#ffffff"));
        butP2.setTextColor(Color.parseColor("#ff0006"));
        butP1.setBackgroundColor(Color.parseColor("#ffffff"));
        butP1.setTextColor(Color.parseColor("#ff0006"));


        gameisactive = true;

    }


    int [] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int activeplayer = 0;
    int [] [] winning = {{0,1,2},{3,4,5},{6,  7, 8}, {0 , 3, 6} , {1, 4, 7} , {2 , 5, 8}, {0, 4, 8} , {2, 4 , 6}};

    boolean gameisactive = true;


    public void dropIn(View view) {
        Button butNew = (Button) findViewById(R.id.playagain);
        if (gameisactive) {
            ImageView icon = (ImageView) view;

            int mytag = Integer.parseInt(icon.getTag().toString());

            if (gameState[mytag] == 2) {
                TextView butP1 = (TextView) findViewById(R.id.player1);
                TextView butP2 = (TextView) findViewById(R.id.player2);

                if (activeplayer == 0) {
                    gameState[mytag] = activeplayer;

                    butP2.setBackgroundColor(Color.parseColor("#00ff00"));
                    butP2.setTextColor(Color.parseColor("#ffffff"));
                    butP1.setBackgroundColor(Color.parseColor("#ffffff"));
                    butP1.setTextColor(Color.parseColor("#ff0006"));
                    icon.setTranslationY(-1200);
                    icon.setImageResource(R.drawable.bb);
                    icon.animate().translationYBy(1200f).rotation(360).setDuration(400);
                    activeplayer = 1;
                } else {
                    gameState[mytag] = activeplayer;
                    butP1.setBackgroundColor(Color.parseColor("#00ff00"));
                    butP1.setTextColor(Color.parseColor("#ffffff"));
                    butP2.setBackgroundColor(Color.parseColor("#ffffff"));
                    butP2.setTextColor(Color.parseColor("#ff0006"));
                    icon.setTranslationY(-1200);
                    icon.setImageResource(R.drawable.aa);
                    icon.animate().translationYBy(1200f).rotation(360).setDuration(400);
                    activeplayer = 0;


                }

                for (int[] winningP : winning) {

                        if (gameState[winningP[0]] == gameState[winningP[1]] && gameState[winningP[1]] == gameState[winningP[2]]
                                && gameState[winningP[0]] != 2)
                        {
                                if (gameState[winningP[0]] != 0) {

                                    Toast.makeText(MainActivity.this, "Player 2 has won!", Toast.LENGTH_LONG).show();
                                    butP1.setBackgroundColor(Color.parseColor("#536878"));
                                    butP1.setTextColor(Color.parseColor("#536878"));

                                    butNew.setVisibility(View.VISIBLE);
                                    gameisactive = false;
                                    break;
                                } else {

                                    Toast.makeText(MainActivity.this, "Player 1 has won!", Toast.LENGTH_LONG).show();
                                    butP2.setBackgroundColor(Color.parseColor("#536878"));
                                    butP2.setTextColor(Color.parseColor("#536878"));

                                    butNew.setVisibility(View.VISIBLE);
                                    gameisactive = false;
                                    break;
                                }
                        }else {
                            boolean gameisover = true;
                          for(int counterState : gameState){

                                if(counterState == 2){
                                    gameisover = false;
                                }

                          }

                          if(gameisover){


                                  Toast.makeText(MainActivity.this, "It's a tie!", Toast.LENGTH_LONG).show();
                                  butNew.setVisibility(View.VISIBLE);
                                  butP1.setBackgroundColor(Color.parseColor("#536878"));
                                  butP1.setTextColor(Color.parseColor("#536878"));
                                  butP2.setBackgroundColor(Color.parseColor("#536878"));
                                  butP2.setTextColor(Color.parseColor("#536878"));

                          }////
                            }


                        }

                }




            }

        }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}
