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

    public EditText emailId = findViewById(R.id.email);
    public EditText password = findViewById(R.id.password);
    public FirebaseAuth mAuth;
    private  String TAG = "SignInAct";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            try{
                String emailText = emailId.getText().toString();
                String passText = password.getText().toString();
                mAuth.signInWithEmailAndPassword(emailText,passText).addOnCompleteListener(
                        this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull  Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Log.d(TAG, "Successful SignIn");
                                }
                                else{
                                    Log.d(TAG,"Not Successful SignIn");
                                    Toast.makeText(SignInActivity.this, "", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                );
                if(emailText.isEmpty() || passText.isEmpty()){
                    throw new EmptyFieldException("Either User name or password is empty");
                }
            }catch(EmptyFieldException e){
                Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }

    }
}