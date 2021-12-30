package com.example.cfmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cfmatch.dao.UserDao;
import com.example.cfmatch.entities.User;

import java.util.List;

public class login extends AppCompatActivity {
    private EditText email, password;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userDao = new UserDao(this);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
    }

    private User getUserByEmailAndPassword (List<User> users, String email, String password) {
        for (User user: users) {
            if (user.email.equals(email) && user.password.equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void submit(View c) {
        String valueEmail = email.getText().toString();
        String valuePassword = password.getText().toString();

        List<User> users = userDao.getAll();

        User loggedUser = getUserByEmailAndPassword(users, valueEmail, valuePassword);

        if(!validFieldsRequired()){
            return;
        }

        if (loggedUser == null) {
            Context context = getApplicationContext();
            CharSequence text = "Email ou senha inválidos.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }

        Intent i = new Intent(getBaseContext(), Matches.class);
        i.putExtra("userId", (int) loggedUser.id);
        startActivity(i);
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