package com.example.cfmatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.cfmatch.dao.InterestDao;
import com.example.cfmatch.dao.InterestUserDao;
import com.example.cfmatch.entities.Interest;
import com.example.cfmatch.entities.User;
import com.example.cfmatch.entities.UserInterest;

import java.util.List;

public class AddInterest extends AppCompatActivity {

    private EditText title;
    private RecyclerView recyclerView;
    private AdapterRecycler adapter;
    private int userId;
    private InterestDao interestDao;
    private InterestUserDao interestUserDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        recyclerView = findViewById(R.id.myRecycler);
        title = findViewById(R.id.username);
        Intent i = getIntent();
        userId = i.getIntExtra("userId", 0);

        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        adapter = new AdapterRecycler();

        recyclerView.setAdapter(adapter);
        interestDao = new InterestDao(this);
        interestUserDao = new InterestUserDao(this);
        adapter.eventClickLine = new EventClickLine<Interest>() {
            @Override
            public void onItemClick(Interest dataLine) {

            }
        };
    }

    public void onClickNoAdd(View v) {
        String info = title.getText().toString();
        Interest interest = new Interest();
        UserInterest userInterest = new UserInterest();
        interest.title = info;
        List<Interest> interests = interestDao.getAll();
        boolean verify = false;
        int interestId = 0;

        for(Interest a : interests) {
            if(a.title.equalsIgnoreCase(info)) {
                verify = true;
                interestId = (int) a.id;
            }
        }
        // se não achar um com o title igual add o novo interesse
        if(!verify) {
            System.out.println("Adicionou!!!!!!!!!!!!!!!!!!!");
            interestId = (int) interestDao.insert(interest);
        }

        User user = new User();
        user.addInterests(interest, userId);
        user.id = userId;

        userInterest.interestId = (int) interestId;
        userInterest.userId = (int) userId;

        interestUserDao.insert(userInterest);


        adapter.get().add(interest);
        adapter.notifyDataSetChanged();
    }
}