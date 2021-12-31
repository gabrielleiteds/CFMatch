package com.example.cfmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cfmatch.dao.UserDao;
import com.example.cfmatch.entities.User;

import java.util.List;

public class AnotherUserProfile extends AppCompatActivity {

    private long userId;
    private TextView usernameTv;
    private TextView emailTv;
    private TextView descriptionTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_user_profile);

        usernameTv = findViewById(R.id.another_user_name);
        emailTv = findViewById(R.id.another_user_email);
        descriptionTv = findViewById(R.id.another_user_description);

        Intent i = getIntent();
        userId = i.getIntExtra("userId", 0);

        User user = getUserById(userId);

        usernameTv.setText(user.name);
        emailTv.setText(user.email);
        descriptionTv.setText(user.description);

    }

    public User getUserById(long userId) {
        List<User> users = new UserDao(this).getAll();
        for (User user: users) {
            if ((int) userId == (int) user.id) {
                return user;
            }
        }
        return null;
    }
}