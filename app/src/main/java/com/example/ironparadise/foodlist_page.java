package com.example.ironparadise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
public class foodlist_page extends AppCompatActivity {

    private ImageButton protein_button;
    private ImageButton carbs_button;
    private ImageButton fat_button;
    private ImageButton backbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodlist_page);


        protein_button=(ImageButton)findViewById(R.id.protein_button);
        protein_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_Diet_page();
            }
        });




        carbs_button=(ImageButton)findViewById(R.id.carbs_button);
        carbs_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_carbohydrate_page();
            }
        });



        fat_button=(ImageButton)findViewById(R.id.fat_button);
        fat_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_fat_page();
            }
        });


        backbutton = (ImageButton) findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(foodlist_page.this,choose_goals_page.class);
                startActivity(intent);
            }
        });




    }


    public void open_Diet_page()
    {

        Intent intent = new Intent(this, com.example.ironparadise.Diet_page.class);
        startActivity(intent);


    }


    public void open_carbohydrate_page()
    {

        Intent intent = new Intent(this, com.example.ironparadise.carbohydrate_page.class);
        startActivity(intent);


    }


    public void open_fat_page()
    {

        Intent intent = new Intent(this, com.example.ironparadise.fat_page.class);
        startActivity(intent);


    }



}