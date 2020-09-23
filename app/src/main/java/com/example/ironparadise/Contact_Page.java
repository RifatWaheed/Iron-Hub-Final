package com.example.ironparadise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Contact_Page extends AppCompatActivity {
    private ImageButton backbutton;
    private TextView pabongmail;
    private TextView rifatgmail;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__page);

        backbutton = (ImageButton) findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Contact_Page.this,MainActivity.class);
                startActivity(intent);
            }
        });

        pabongmail = (TextView) findViewById(R.id.pabongmail);
        rifatgmail = (TextView) findViewById(R.id.rifatgmail);
        reff = FirebaseDatabase.getInstance().getReference().child("Gmail").child("1");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String pabon1 = dataSnapshot.child("pabon").getValue().toString();
                String rifat1 = dataSnapshot.child("rifat").getValue().toString();

                pabongmail.setText(pabon1);
                rifatgmail.setText(rifat1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }
}