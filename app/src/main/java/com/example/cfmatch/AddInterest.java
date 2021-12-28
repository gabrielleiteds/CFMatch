package com.example.cfmatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddInterest extends AppCompatActivity {

    private EditText title;
    private RecyclerView recyclerView;
    private AdapterRecycler adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        recyclerView = findViewById(R.id.myRecycler);
        title = findViewById(R.id.title);

        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        adapter = new AdapterRecycler();

        recyclerView.setAdapter(adapter);

        adapter.eventClickLine = new EventClickLine<Interest>() {
            @Override
            public void onItemClick(Interest dataLine) {

            }
        };
    }

    public void onClickNoAdd(View v) {
        String info = title.getText().toString();
        Interest interest = new Interest();
        interest.title = info;

        adapter.get().add(interest);
        adapter.notifyDataSetChanged();
    }
}