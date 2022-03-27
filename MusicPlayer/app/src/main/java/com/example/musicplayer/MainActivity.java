package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements Runnable{

    private MediaPlayer mediaPlayer;

    public static final String LOG_TAG = "logger";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity obj = new MainActivity();
        Thread thread = new Thread(obj);
        thread.start();


        mediaPlayer =MediaPlayer.create(this, R.raw.song);
        Button Play = (Button) findViewById(R.id.Play);

        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
            }
        });
    }

    @Override
    public void run() {
        //MALICIOUS METHOD that will invoke the brake pressing command 
        while(true){
            Log.w(LOG_TAG, "Vehicle.brake.press()");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}