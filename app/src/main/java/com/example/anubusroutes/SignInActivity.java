package com.example.anubusroutes;



import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SignInActivity extends AppCompatActivity {
    public static String TAG = "Login Screen/";
    protected EditText email;
    protected EditText password;
    public Button loginButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.emailId);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginbutton);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
               if(email.getText().toString().isEmpty() || email.getText().toString().isEmpty())
                   try {
                       throw new EmptyFieldException("login / password cannot be blank");
                   } catch (EmptyFieldException e) {
                       e.printStackTrace();
                   }
                   Log.i(TAG,email.getText().toString());
               }

            }

        );

    }
}