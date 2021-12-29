package com.example.cfmatch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cfmatch.entities.Interest;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<ModelLine> {
    private final List<Interest> interestList;
    private Context activityExecution; // Usado em metodos para acesso à tela

    public List<Interest> get() { return interestList; }

    public AdapterRecycler() {
        interestList = new ArrayList<>();
    }

    public EventClickLine<Interest> eventClickLine = null;

    @NonNull
    @Override
    public ModelLine onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        activityExecution = parent.getContext();

        ModelLine holder = new ModelLine(LayoutInflater.from(activityExecution).inflate(R.layout.model_line, parent, false));

        if(eventClickLine != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Interest data = get().get(holder.position);

                    eventClickLine.onItemClick(data);
                }
            });
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(ModelLine modelLine, @SuppressLint("RecyclerView") int position) {
        Interest data = interestList.get(position);
        modelLine.title.setText(data.title);
        modelLine.position = position;
    }

    @Override
    public int getItemCount() {
        return interestList.size();
    }
}
