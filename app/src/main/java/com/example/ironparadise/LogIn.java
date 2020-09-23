package com.example.ironparadise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity implements View.OnClickListener {


    private EditText signInEmailEditText,signInPasswordEditText;
    private TextView signUpTextView;
    private Button logInButton;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        this.setTitle("SIGN IN");

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        signInEmailEditText=findViewById(R.id.signInEmailEditTextId);
        signInPasswordEditText=findViewById(R.id.signInPasswordEditTextId);
        signUpTextView=findViewById(R.id.signUptextViewId);
        logInButton=findViewById(R.id.logInButtonId);
        progressBar=findViewById(R.id.progressBarId);


        signUpTextView.setOnClickListener(this);
        logInButton.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.logInButtonId:

                userLogIn();
                break;


            case R.id.signUptextViewId:

                Intent intent = new Intent(getApplicationContext(), SignUp.class);

                startActivity(intent);


                break;


        }

    }

    private void userLogIn() {

        String email=signInEmailEditText.getText().toString().trim();
        String password=signInPasswordEditText.getText().toString().trim();


        //checking the validity of the email
        if(email.isEmpty())
        {
            signInEmailEditText.setError("Enter an email address");
            signInEmailEditText.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signInEmailEditText.setError("Enter a valid email address");
            signInEmailEditText.requestFocus();
            return;
        }

        //checking the validity of the password
        if(password.isEmpty())
        {
            signInPasswordEditText.setError("Enter a password");
            signInPasswordEditText.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressBar.setVisibility(View.GONE);

                if (task.isSuccessful())
                {

                    finish();

                    Intent intent=new Intent(getApplicationContext(),Admin.class);

                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "LOG IN SUCCESSFULL", Toast.LENGTH_SHORT).show();


                }
                else {

                    Toast.makeText(getApplicationContext(), "LOG IN IS NOT SUCCESSFUL", Toast.LENGTH_SHORT).show();
                }


            }
        });





    }



}