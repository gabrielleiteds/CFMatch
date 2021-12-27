package com.example.cfmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class register extends AppCompatActivity {
    private EditText name, email, password, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        description = findViewById(R.id.description);
    }

    public void submit(View c) {
        String valueName = name.getText().toString();
        String valueEmail = email.getText().toString();
        String valuePassword = password.getText().toString();
        String valueDescription = description.getText().toString();

        if(!validFieldsRequired()){
            return;
        }
    }

    public boolean validFieldsRequired(){
        if(name.getText().toString().isEmpty()) {
            this.name.setError("Nome é um campo obrigatório");
            return false;
        }
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