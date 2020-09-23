package com.example.ironparadise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
public class diet_plan_weightloss_page extends AppCompatActivity {

    private Button recommended_foodlist_button;
    private ImageButton backbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plan_weightloss_page);

        recommended_foodlist_button = (Button)findViewById(R.id.recommended_foodlist_button);

        backbutton = (ImageButton) findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(diet_plan_weightloss_page.this,lose_fat_page.class);
                startActivity(intent);
            }
        });





        recommended_foodlist_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_foodlist_page();
            }
        });


    }


    public void open_foodlist_page()
    {

        Intent intent = new Intent(this, com.example.ironparadise.foodlist_page.class);
        startActivity(intent);


    }




}