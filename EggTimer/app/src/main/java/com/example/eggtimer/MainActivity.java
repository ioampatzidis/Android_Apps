package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar countdown;
    Button button1;
    TextView timer;
    Boolean counterIsActive = false;
    CountDownTimer countDownTimer ;
    MediaPlayer mediaPlayer;
    boolean x =true;



    public void soundplay()
    {

        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.alarm); // we can get this
        mediaPlayer.start();



    }
    public void soundstop()
    {

        mediaPlayer.stop();

    }


    public void controllTimer(View view){


        if(counterIsActive==false)
             {

                counterIsActive = true;
                button1.setText("Stop");
                countdown.setEnabled(false); //disable seekbar
                int a =countdown.getProgress() *1000 +100;// i get the seconds from here
                countDownTimer =  new CountDownTimer(a, 1000)
                {
                    @Override
                    public void onTick(long l) // the variable l is millis until finished
                    {
                        int aaa = (int)l ;
                        changeCounter(aaa/1000);

                    }

                    @Override
                    public void onFinish() {
                        Log.i("Finishes","timer is done");
                        timer.setText("0:00");
                        soundplay();
                        countDownTimer.cancel();
                        button1.setText("Go");
                        countdown.setEnabled(true);
                        counterIsActive = false;

                    }
                }.start();

             }
        else
            {
                timer.setText("00:30");
                countdown.setProgress(30);
                countDownTimer.cancel();
                button1.setText("Go");
                counterIsActive = false;
                countdown.setEnabled(true);

            }




    }

    public void changeCounter(Integer i)
    {

            int minutes = i/60;
            int seconds = i - minutes*60;
            timer.setText(Integer.toString(minutes) + ":" + Integer.toString(seconds));
            if (seconds == 0){

                timer.setText(Integer.toString(minutes) + ":" + Integer.toString(seconds)+ "0");
                //counterIsActive = true;

            }else if(seconds <=9){
                timer.setText(Integer.toString(minutes) + ":" +"0" + Integer.toString(seconds));
            }




    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         timer = (TextView)findViewById(R.id.textView) ;
         button1 = (Button)findViewById(R.id.button);
         countdown = (SeekBar)findViewById(R.id.seekBar);
        // mediaPlayer.stop();
        countdown.setMax(600);
        countdown.setProgress(30);
        countdown.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                changeCounter(i);
                x =true;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
