package com.example.rybackpo.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // records the number of seconds
    private int seconds = 0;
    // records if the application is running
    private boolean running;
    // record if it was running before
    private boolean runningAwhileAgo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            runningAwhileAgo = savedInstanceState.getBoolean("runningAwhileAgo");
        }
        runTimer();
    }

    @Override
    protected void onStart(){
        super.onStart();
        running = runningAwhileAgo;
    }

    @Override
    protected void onResume(){
        super.onResume();
        running = runningAwhileAgo;
    }

    @Override
    protected void onPause(){
        super.onPause();
        runningAwhileAgo = running;
        running = false;
    }

    @Override
    protected void onStop(){
        super.onStop();
        runningAwhileAgo = running;
        running = false;
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("runningAwhileAgo", runningAwhileAgo);
    }

    public void ClickStart(View view){
        running = true;
        Toast.makeText(this, "Timer Start", Toast.LENGTH_SHORT).show();
    }

    public void ClickStop(View view){
        running = false;
        Toast.makeText(this, "Stop Timer", Toast.LENGTH_SHORT).show();
    }

    public void ClickRestart(View view){
        running = false;
        seconds = 0;
        Toast.makeText(this, "Restart Timer", Toast.LENGTH_SHORT).show();
    }

    private void runTimer(){

        final TextView viewTime = (TextView) findViewById(R.id.timer);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run(){
                int hours = seconds/3600; // divide seconds by 3600 to get the hours
                int minutes = (seconds%3600)/60; // remainder of hours divided by 60 to get the minutes
                int secs = seconds%60;
                String formattime = String.format("%d:%02d:%02d", hours, minutes,secs);
                viewTime.setText(formattime);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}
