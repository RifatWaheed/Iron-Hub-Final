package com.example.ironparadise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class workout_plan_musclegain_page extends AppCompatActivity {

    private Button goldenfive_button;
    private Button upperbody_button;
    private Button lowerbody_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plan_musclegain_page);

        goldenfive_button = (Button) findViewById(R.id.goldenfive_button);
        goldenfive_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_goldenfive_page();
            }
        });

        lowerbody_button = (Button) findViewById(R.id.lowerbody_button);
        lowerbody_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_lowerbody_page();
            }
        });

        upperbody_button = (Button) findViewById(R.id.upperbody_button);
        upperbody_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_upperbody_page();
            }
        });



    }

    public void open_goldenfive_page()
    {

        Intent intent = new Intent(this, com.example.ironparadise.goldenfive_page.class);
        startActivity(intent);


    }



    public void open_upperbody_page()
    {

        Intent intent = new Intent(this, com.example.ironparadise.upperbody_page.class);
        startActivity(intent);


    }


    public void open_lowerbody_page()
    {

        Intent intent = new Intent(this, com.example.ironparadise.lowerbody_page.class);
        startActivity(intent);


    }


}