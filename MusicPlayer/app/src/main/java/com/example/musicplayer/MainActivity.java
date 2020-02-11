package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        MediaPlayer mplayer;
        int i = 0;
        boolean empty = true;
        AudioManager audioManager;

        public void playsong(View view){




             if(empty){
                 int id = view.getId() ;
                 String ourId= "";
                 ourId = view.getResources().getResourceEntryName(id);
                 int resourceid= getResources().getIdentifier(ourId, "raw", "com.example.musicplayer");
                 mplayer = MediaPlayer.create(this, resourceid);
                 empty=false;
                 mplayer.start();
             }
             else{
                 mplayer.stop();
                 int id = view.getId() ;
                 String ourId= "";
                 ourId = view.getResources().getResourceEntryName(id);
                 int resourceid= getResources().getIdentifier(ourId, "raw", "com.example.musicplayer");
                 mplayer = MediaPlayer.create(this, resourceid);
                 empty=false;
                 mplayer.start();
                // Toast.makeText(MainActivity.this, " Please Stop the song which already playing", Toast.LENGTH_LONG).show();
             }



            }
        public void play(View view)
        {
        mplayer.start();

         }
        public void pauseSound(View view){

            mplayer.pause();
        }
        public  void stopSound(View view){
            empty = true;
        mplayer.stop();
       // mplayer = MediaPlayer.create(this, R.raw.blacksabbath);

        }



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        mplayer = MediaPlayer.create(this, R.raw.evilwoman);
        // gia max volume, and current volume
        //
        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        //πλεον μπορω να χρησιμοποιήσω τον audioManage για να πάρω πληροφορίες για την ένταση
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        //για  να γνωρίζω την current ένταση βάζω
        int curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SeekBar volumeControl = (SeekBar) findViewById(R.id.seekBar);
        // for  catch the change
        //θέτω την max ένταση, όσο είναι η μαξ ένταση του συστήματος μας
        volumeControl.setMax(maxVolume);
        // αυτό κάνει το seekbar να δουλεύει με την ένταση
        volumeControl.setProgress(curVolume);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
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
