package com.example.ironparadise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Admin extends AppCompatActivity {

    private EditText edittext;
    private EditText edittext2;
    private EditText edittext3;
    private Button savebutton;
    private long maxid = 0;
    DatabaseReference reff;
    Member member;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        edittext = (EditText) findViewById(R.id.edittext);
        edittext2 = (EditText) findViewById(R.id.edittext2);
        edittext3 = (EditText) findViewById(R.id.edittext3);
        savebutton = (Button) findViewById(R.id.savebutton);
        member = new Member();


        reff = FirebaseDatabase.getInstance().getReference().child("Member");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                {
                    maxid = dataSnapshot.getChildrenCount();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                member.setName(edittext.getText().toString().trim());
                member.setSerialno(edittext2.getText().toString().trim());
                member.setDate(edittext3.getText().toString().trim());


                reff.child(String.valueOf(maxid+1)).setValue(member);
                Toast.makeText(Admin.this, "Data Saved", Toast.LENGTH_SHORT).show();

            }
        });







    }


}