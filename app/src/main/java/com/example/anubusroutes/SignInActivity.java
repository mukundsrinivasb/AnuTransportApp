package com.example.anubusroutes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SignInActivity extends AppCompatActivity {

    public EditText emailId;
    public EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailId = findViewById(R.id.email);
        password = findViewById(R.id.password);
        try{
            if(emailId.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                throw new EmptyFieldException("Either User name or password is empty");
            }
            //Login here
        }catch(EmptyFieldException e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }

}