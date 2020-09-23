package com.example.ironparadise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class gain_muscle_workout extends AppCompatActivity {


private Button workout_muscle_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gain_muscle_workout);


        workout_muscle_button = (Button) findViewById(R.id.wourkout_muscle_button);
        workout_muscle_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_workout_plan_musclegain_page();
            }
        });

    }

    public void open_workout_plan_musclegain_page()
    {

        Intent intent = new Intent(this, com.example.ironparadise.workout_plan_musclegain_page.class);
        startActivity(intent);


    }



}