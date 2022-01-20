package com.example.anubusroutes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignInActivity extends AppCompatActivity {
    public static String TAG = "Login Screen/";
    protected EditText email;
    protected EditText password;
    public Button loginButton;
    public FirebaseUser currentUser;
    protected FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.emailId);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginbutton);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        loginButton.setOnClickListener(
                view -> {
                    String emailString = email.getText().toString();
                    String passwordString = password.getText().toString();
                    currentUser = mAuth.getCurrentUser();
                    if (currentUser != null) {
                        Toast.makeText(getBaseContext(), currentUser.getEmail() + "is already logged in", Toast.LENGTH_LONG).show();
                    } else {
                        mAuth.signInWithEmailAndPassword(emailString, passwordString).addOnCompleteListener(SignInActivity.this, task -> {
                            if (task.isSuccessful()) {
                                currentUser = mAuth.getCurrentUser();
                                try {
                                    Log.i(TAG, currentUser.getEmail());
                                    Toast.makeText(getBaseContext(),currentUser.getEmail(),Toast.LENGTH_LONG).show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
        );
    }


}