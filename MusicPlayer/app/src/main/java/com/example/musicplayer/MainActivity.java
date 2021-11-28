package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gauravk.audiovisualizer.visualizer.BarVisualizer;


public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    //BarVisualizer visualizer= findViewById(R.id.bar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer =MediaPlayer.create(this, R.raw.song);
        Button Play = (Button) findViewById(R.id.Play);
        //On click listener to control the music
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id= mediaPlayer.getAudioSessionId();
                if (id != -1) {
                   // visualizer.setAudioSessionId(id);
                }

                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this, "The Song is Over", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button Pause = (Button) findViewById(R.id.Pause);

        Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
               // visualizer.release();
            }
        });

        Button Selectsong = (Button) findViewById(R.id.Select_song);
        Selectsong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }
}