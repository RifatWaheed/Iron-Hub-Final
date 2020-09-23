package com.example.ironparadise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class Tracker_page extends AppCompatActivity {


    private Chronometer chronometer;
    private long PauseOffset = 0;
    private boolean isPlaying = false;
    private ToggleButton toggleButton;
    private ImageButton reset_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker_page);


        chronometer=findViewById(R.id.chronometer);
        toggleButton=findViewById(R.id.start_chorno_button);
        reset_btn=findViewById(R.id.reset_btn);


        toggleButton.setText(null);
        toggleButton.setTextOn(null);
        toggleButton.setTextOff(null);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    chronometer.setBase(SystemClock.elapsedRealtime()-PauseOffset);
                    chronometer.start();
                    isPlaying=true;
                }
                else{

                    chronometer.stop();
                    PauseOffset=SystemClock.elapsedRealtime()-chronometer.getBase();
                    isPlaying=false;

                }

            }
        });


        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                PauseOffset=0;
                chronometer.stop();
                isPlaying=false;
            }
        });


    }
}