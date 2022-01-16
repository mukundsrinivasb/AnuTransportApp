package com.example.anubusroutes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {

    public EditText emailId = findViewById(R.id.emailId);
    public EditText password = findViewById(R.id.password);
    public FirebaseAuth mAuth;
    private  String TAG = "SignInAct";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_ANUBusRoutes);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        Log.w(TAG, "onCreate: words");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Log.i(TAG, "user: "+currentUser.getEmail());
        }
        else{

        }


    }
}