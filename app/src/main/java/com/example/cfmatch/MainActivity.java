package com.example.cfmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void aboutUs (View c) {
        Intent i = new Intent(getBaseContext(), AboutUs.class);
        startActivity(i);
    }

    public void register(View c) {
        Intent i = new Intent(getBaseContext(), register.class);

        startActivity(i);
    }

    public void login(View c) {
        Intent i = new Intent(getBaseContext(), login.class);

        startActivity(i);
    }
}