package com.example.cfmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cfmatch.dao.UserDao;
import com.example.cfmatch.entities.User;

public class UpdateUser extends AppCompatActivity {

    private TextView layoutName, layoutPassword, layoutEmail, layoutDescription;
    private int userId;
    private UserDao userDao;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        userDao = new UserDao(this);

        layoutDescription = findViewById(R.id.description);
        layoutName = findViewById(R.id.name);
        layoutEmail = findViewById(R.id.email);
        layoutPassword = findViewById(R.id.password);

        Intent i = getIntent();

        userId = i.getIntExtra("userId", 0);
        String description = i.getStringExtra("description");
        String email = i.getStringExtra("email");
        String username = i.getStringExtra("username");
        password = i.getStringExtra("password");

        layoutDescription.setText(description);
        layoutName.setText(username);
        layoutEmail.setText(email);
    }

    public void update(View c) {
        User user = new User();
        System.out.println(layoutName.getText().toString());
        user.description = layoutDescription.getText().toString();
        user.name = layoutName.getText().toString();
        user.email = layoutEmail.getText().toString();

        if(layoutPassword.getText().toString().isEmpty()) {
            user.password = password;
        } else {
            user.password = layoutPassword.getText().toString();
        }

        userDao.update(user, String.valueOf(userId));

        Intent i = new Intent(getBaseContext(), UserProfile.class);

        i.putExtra("userId", userId);

        startActivity(i);
    }
}