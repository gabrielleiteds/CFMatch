package com.example.cfmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class login extends AppCompatActivity {
    private EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
    }

    public void submit(View c) {
        String valueEmail = email.getText().toString();
        String valuePassword = password.getText().toString();


        if(!validFieldsRequired()){
            return;
        }
    }

    public boolean validFieldsRequired(){
        if(email.getText().toString().isEmpty()) {
            this.email.setError("Email é um campo obrigatório");
            return false;
        }
        if(password.getText().toString().isEmpty()) {
            this.password.setError("Password é um campo obrigatório");
            return false;
        }

        return true;
    }
}