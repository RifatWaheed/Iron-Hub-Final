package com.example.ironparadise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
public class lose_fat_page extends AppCompatActivity {

    private Button diet_plan_weightloss_button;
    private Button workout_plan_weightloss_button;
    private ImageButton backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_fat_page);

        diet_plan_weightloss_button=(Button)findViewById(R.id.diet_plan_weightloss_button);


        backbutton = (ImageButton) findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lose_fat_page.this,choose_goals_page.class);
                startActivity(intent);
            }
        });





        diet_plan_weightloss_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_diet_plan_for_weightloss();
            }
        });


        workout_plan_weightloss_button=(Button)findViewById((R.id.workout_plan_weightloss_button));

        workout_plan_weightloss_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_workout_plan_for_weightloss();
            }
        });

    }

    public void open_diet_plan_for_weightloss(){


        Intent intent = new Intent(this, com.example.ironparadise.diet_plan_weightloss_page.class);
        startActivity(intent);


    }



    public void open_workout_plan_for_weightloss(){


        Intent intent = new Intent(this, com.example.ironparadise.workout_plan_weightloss_page.class);
        startActivity(intent);


    }



}