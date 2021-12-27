package com.example.cfmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.cfmatch.dao.UserDao;
import com.example.cfmatch.entities.User;

public class register extends AppCompatActivity {
    private EditText name, email, password, description;
    private UserDao userDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        description = findViewById(R.id.description);
        userDao = new UserDao(this);
    }

    public void submit(View c) {
        String valueName = name.getText().toString();
        String valueEmail = email.getText().toString();
        String valuePassword = password.getText().toString();
        String valueDescription = description.getText().toString();

        if(!validFieldsRequired()){
            return;
        }

        User user = new User(valueEmail, valuePassword, valueName, valueDescription);
        long id = userDao.insert(user);
        System.out.println(id);

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