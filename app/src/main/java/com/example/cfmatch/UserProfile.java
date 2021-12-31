package com.example.cfmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cfmatch.dao.InterestDao;
import com.example.cfmatch.dao.InterestUserDao;
import com.example.cfmatch.dao.UserDao;
import com.example.cfmatch.entities.Interest;
import com.example.cfmatch.entities.User;
import com.example.cfmatch.entities.UserInterest;

import java.util.ArrayList;
import java.util.List;

public class UserProfile extends AppCompatActivity {

    private int userId;
    private User user;
    private TextView username, email, description, interests;
    private UserDao userDao;
    private InterestDao interestDao;
    private InterestUserDao userInterestDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        userDao = new UserDao(this);
        userInterestDao = new InterestUserDao(this);
        interestDao = new InterestDao(this);

        Intent i = getIntent();
        userId = i.getIntExtra("userId", 0);

        username = findViewById(R.id.name);
        email = findViewById(R.id.email);
        description = findViewById(R.id.description);
        interests = findViewById(R.id.interests);

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

                List<UserInterest> userInterests = userInterestDao.getAll();
                List<Interest> interestsList = interestDao.getAll();
                List<String> interestUserList = new ArrayList<>();

                for(UserInterest userInterest : userInterests) {
                    if(userInterest.userId == userId) {
                        for (Interest interest : interestsList) {
                            if(interest.id == userInterest.interestId) {
                                interestUserList.add(interest.title);
                            }
                        }
                    }
                }

                String text = "";
                for(String title : interestUserList) {
                    text += title + ", ";
                    interests.setText(text);
                }

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