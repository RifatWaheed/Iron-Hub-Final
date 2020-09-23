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

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private EditText signUpEmailEditText, signUpPasswordEditText;
    private TextView signInTextView;
    private Button signUpButton;
    private FirebaseAuth mAuth;
    private ProgressBar signUpProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("SIGN UP");

        mAuth = FirebaseAuth.getInstance();

        signUpEmailEditText = findViewById(R.id.signUpEmailEditTextId);
        signUpPasswordEditText = findViewById(R.id.signUpPasswordEditTextId);
        signInTextView = findViewById(R.id.signInTextViewId);
        signUpButton = findViewById(R.id.signUpButtonId);

        signUpProgressBar = findViewById(R.id.signUpProgressBarId);

        signInTextView.setOnClickListener(this);
        signUpButton.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.signUpButtonId:

                userRegister();


                break;


            case R.id.signInTextViewId:

                Intent intent = new Intent(getApplicationContext(), LogIn.class);

                startActivity(intent);


                break;


        }

    }

    private void userRegister() {

        signUpProgressBar.setVisibility(View.VISIBLE);

        String email = signUpEmailEditText.getText().toString().trim();
        String password = signUpPasswordEditText.getText().toString().trim();


        //checking the validity of the email
        if (email.isEmpty()) {
            signUpEmailEditText.setError("Enter an email address");
            signUpEmailEditText.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signUpEmailEditText.setError("Enter a valid email address");
            signUpEmailEditText.requestFocus();
            return;
        }

        //checking the validity of the password
        if (password.isEmpty()) {
            signUpPasswordEditText.setError("Enter a password");
            signUpPasswordEditText.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        signUpProgressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {

                            finish();

                            Intent intent = new Intent(getApplicationContext(), Admin.class);

                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                            startActivity(intent);

                            Toast.makeText(getApplicationContext(), "SUCCESSFULLY REGISTERED", Toast.LENGTH_SHORT).show();

                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(getApplicationContext(), "REGISTER IS NOT SUCCESSFUL", Toast.LENGTH_SHORT).show();


                        }

                        // ...
                    }
                });

    }
}

