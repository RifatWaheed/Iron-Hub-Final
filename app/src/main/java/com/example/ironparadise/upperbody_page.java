package com.example.ironparadise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class upperbody_page extends AppCompatActivity {


    private Button chest_button;
    private Button back_button;
    private Button shoulder_button;
    private Button arms_button;
    private Button abs_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upperbody_page);



        chest_button = (Button) findViewById(R.id.chest_button);
        chest_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_chest_page();
            }
        });


        back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_back_workout_page();
            }
        });




        shoulder_button=(Button) findViewById(R.id.shoulder_button);
        shoulder_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_shoulder_page();
            }
        });




        arms_button=(Button) findViewById(R.id.arms_button);
        arms_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_arms_page();
            }
        });



        abs_button=(Button) findViewById(R.id.abs_button);
        abs_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_abs_page();
            }
        });




    }


    public void open_chest_page()
    {

        Intent intent = new Intent(this, com.example.ironparadise.chest_page.class);
        startActivity(intent);


    }



    public void open_back_workout_page()
    {

        Intent intent = new Intent(this, com.example.ironparadise.back_workout_page.class);
        startActivity(intent);


    }





    public void open_shoulder_page()
    {

        Intent intent = new Intent(this, com.example.ironparadise.shoulders_page.class);
        startActivity(intent);


    }




    public void open_arms_page()
    {

        Intent intent = new Intent(this, com.example.ironparadise.Arms_page.class);
        startActivity(intent);


    }


    public void open_abs_page()
    {

        Intent intent = new Intent(this, com.example.ironparadise.abs_page.class);
        startActivity(intent);


    }



}