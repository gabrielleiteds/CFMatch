package com.example.cfmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cfmatch.dao.UserDao;
import com.example.cfmatch.entities.User;

import java.util.ArrayList;
import java.util.List;

public class Matches extends AppCompatActivity {

    ArrayList<User> matchesData;
    CustomAdapter customAdapter;
    Button goToProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        Intent i = getIntent();

        ListView listView = (ListView) findViewById(R.id.listView);

        matchesData = new ArrayList(getUserMatches());
        customAdapter = new CustomAdapter(this, matchesData);

        goToProfile = (Button) findViewById(R.id.btn_go_to_profile);

        listView.setAdapter(customAdapter);
    }

    public void submit (View c) {
        Intent i = getIntent();
        long userId = i.getIntExtra("userId", 0);

        i = new Intent(getBaseContext(), UserProfile.class);
        i.putExtra("userId", (int) userId);
        startActivity(i);

    }

    private List<User> getUserMatches() {
        return new UserDao(this).getAll();
    }

    public void profile(View c) {
        Intent i = new Intent(getBaseContext(), UserProfile.class);
        i.putExtra("userId", userId);
        startActivity(i);
    }
}

