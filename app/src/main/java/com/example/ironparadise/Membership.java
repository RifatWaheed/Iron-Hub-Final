package com.example.ironparadise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Membership extends AppCompatActivity {

    private ImageButton backbutton;
    private TextView date;
    private TextView serialno;
    private DatabaseReference reff,reff2,reff3;
    private TextView name,name2,name3;
    private TextView date2,date3;
    private TextView serialno2,serialno3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);


        name = (TextView) findViewById(R.id.name);
        date = (TextView) findViewById(R.id.date);
        serialno = (TextView) findViewById(R.id.serialno);
        name2 = (TextView) findViewById(R.id.name2);
        date2 = (TextView) findViewById(R.id.date2);
        serialno2 = (TextView) findViewById(R.id.serialno2);
        name3 = (TextView) findViewById(R.id.name3);
        date3 = (TextView) findViewById(R.id.date3);
        serialno3 = (TextView) findViewById(R.id.serialno3);

        backbutton = (ImageButton) findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Membership.this,MainActivity.class);
                startActivity(intent);
            }
        });


        reff = FirebaseDatabase.getInstance().getReference().child("Member").child("1");





        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String name1 = dataSnapshot.child("name").getValue().toString();
                String serialno1 = dataSnapshot.child("serialno").getValue().toString();
                String date1 = dataSnapshot.child("date").getValue().toString();

                name.setText(name1);
                serialno.setText(serialno1);
                date.setText(date1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        reff2 = FirebaseDatabase.getInstance().getReference().child("Member").child("2");

        reff2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String namea = dataSnapshot.child("name").getValue().toString();
                String serialnoa = dataSnapshot.child("serialno").getValue().toString();
                String datea = dataSnapshot.child("date").getValue().toString();

                name2.setText(namea);
                serialno2.setText(serialnoa);
                date2.setText(datea);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        reff3 = FirebaseDatabase.getInstance().getReference().child("Member").child("3");
        reff3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String nameb = dataSnapshot.child("name").getValue().toString();
                String serialnob = dataSnapshot.child("serialno").getValue().toString();
                String dateb = dataSnapshot.child("date").getValue().toString();

                name3.setText(nameb);
                serialno3.setText(serialnob);
                date3.setText(dateb);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
















    }
}