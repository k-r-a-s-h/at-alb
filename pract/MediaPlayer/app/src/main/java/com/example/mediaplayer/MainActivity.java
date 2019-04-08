package com.example.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    static MediaPlayer myMediaPlayer;
    Button play,pause,forward,backward,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play=findViewById(R.id.play);
        pause=findViewById(R.id.pause);
        forward=findViewById(R.id.forward);
        backward=findViewById(R.id.backward);
        stop=findViewById(R.id.stop);
        if(myMediaPlayer!=null){
            myMediaPlayer.stop();
            myMediaPlayer.release();
        }

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPause();
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendForward();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setStop();
            }
        });

        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBackward();
            }
        });


    }

    public void sendForward(){
        if(myMediaPlayer==null){
            return;
        }
        else{
            if(myMediaPlayer.getCurrentPosition()+10<myMediaPlayer.getDuration()){
                myMediaPlayer.seekTo(myMediaPlayer.getCurrentPosition()+(10*1000));
                return;
            }

        }
    }
    public void  sendBackward(){
        if(myMediaPlayer==null){
            return;
        }
        else{
            if(myMediaPlayer.getCurrentPosition()-10>0){
                myMediaPlayer.seekTo(myMediaPlayer.getCurrentPosition()-(10*1000));
                return;
            }
        }
    }
    public void setPause(){
        if(myMediaPlayer==null){
            return;
        }
        else if(myMediaPlayer.isPlaying()){
            myMediaPlayer.pause();
            return;
        }
    }

    public void play(){
        if(myMediaPlayer ==null){
            myMediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.q1);
            myMediaPlayer.start();
        }
        else if(!myMediaPlayer.isPlaying()){
            myMediaPlayer.start();
        }
    }
    public void setStop(){
        if(myMediaPlayer==null){
            return;
        }
        else{
            myMediaPlayer.stop();
            myMediaPlayer.release();
        }
    }
}
