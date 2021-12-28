package com.example.cfmatch;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ModelLine extends RecyclerView.ViewHolder {
    public TextView title;
    public int position = 0;

    public ModelLine(View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.textView2);
    }
}
