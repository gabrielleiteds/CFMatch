package com.example.cfmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cfmatch.dao.UserDao;
import com.example.cfmatch.entities.User;

import java.util.List;

public class UserProfile extends AppCompatActivity {

    private int userId;
    private User user;
    private TextView username, email, description;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        userDao = new UserDao(this);

        Intent i = getIntent();
        userId = i.getIntExtra("userId", 0);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        description = findViewById(R.id.description);

        adjustInfos();
    }

    public void adjustInfos() {
        List<User> users = userDao.getAll();
        for (User user: users) {
            this.user = user;
            if ((int) userId == (int) user.id) {
                description.setText(user.description);
                email.setText(user.email);
                username.setText(user.name);
            }
        }
    }

    public void updateUser(View c) {
        Intent i = new Intent(getBaseContext(), UpdateUser.class);

        i.putExtra("userId", userId);
        i.putExtra("description", description.getText().toString());
        i.putExtra("email", email.getText().toString());
        i.putExtra("username", username.getText().toString());
        i.putExtra("password", user.password.toString());

        startActivity(i);
    }
}