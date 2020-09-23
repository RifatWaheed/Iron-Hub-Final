package com.example.ironparadise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class choose_goals_page extends AppCompatActivity {

    private ImageButton lose_Fat_Button;
    private ImageButton gain_Muscle_Button;
    private Button goBackButton;
    private ImageButton foodlist1;
    private ImageButton gain_weight_imageButton;
    private ImageButton myths_button;
    private ImageButton backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_goals_page);

        lose_Fat_Button = (ImageButton)findViewById(R.id.lose_Fat_Button);
        lose_Fat_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_lose_fat_page();
            }
        });

        foodlist1=(ImageButton)findViewById(R.id.foodlist1);

        foodlist1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_foodlist_page();
            }
        });



        myths_button=(ImageButton)findViewById(R.id.myths_button);
        myths_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_myths_page();
            }
        });



        backbutton = (ImageButton) findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choose_goals_page.this,MainActivity.class);
                startActivity(intent);
            }
        });









        gain_weight_imageButton=(ImageButton)findViewById(R.id.gain_weight_imageButton);
        gain_weight_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_gainweight_page();
            }
        });



        goBackButton = (Button) findViewById(R.id.go_back_button);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_MainPage();
            }
        });


        gain_Muscle_Button = (ImageButton)findViewById(R.id.gain_Muscle_Button);
        gain_Muscle_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_gain_muscle_workout_page();
            }
        });
    }

    public void open_lose_fat_page()
    {

        Intent intent = new Intent(this, com.example.ironparadise.lose_fat_page.class);
        startActivity(intent);


    }


    public void open_MainPage()
    {

        Intent intent = new Intent(this, com.example.ironparadise.MainActivity.class);
        startActivity(intent);


    }


    public void open_gain_muscle_workout_page()
    {

        Intent intent = new Intent(this, com.example.ironparadise.gain_muscle_workout.class);
        startActivity(intent);


    }



    public void open_foodlist_page()
    {

        Intent intent = new Intent(this, com.example.ironparadise.foodlist_page.class);
        startActivity(intent);


    }


    public void open_gainweight_page()
    {

        Intent intent = new Intent(this, com.example.ironparadise.gain_weight_page.class);
        startActivity(intent);


    }



    public void open_myths_page()
    {

        Intent intent = new Intent(this, com.example.ironparadise.myths_page.class);
        startActivity(intent);


    }


}
