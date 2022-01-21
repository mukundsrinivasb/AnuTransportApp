package com.example.anubusroutes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MapActivity extends AppCompatActivity {

    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Intent intent = getIntent();
        username = intent.getStringExtra("USERNAME");
    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView tView = findViewById(R.id.TextViewVerbose);
        tView.setText(username);
    }
}