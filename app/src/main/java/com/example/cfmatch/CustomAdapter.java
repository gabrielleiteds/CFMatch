package com.example.cfmatch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cfmatch.entities.User;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<User> matchesData;
    LayoutInflater layoutInflater;
    User match;
    View rowView;
    public CustomAdapter(Context context, ArrayList<User> matchesData) {
        this.context = context;
        this.matchesData = matchesData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return matchesData.size();
    }

    @Override
    public Object getItem(int i) {
        return matchesData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return matchesData.get(i).id;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        rowView = view;

        if (rowView==null) {
            rowView = layoutInflater.inflate(R.layout.match, null, true);
        }

        TextView usernameTv = rowView.findViewById(R.id.usernameTv);
        TextView descriptionTv = rowView.findViewById(R.id.descriptionTv);

        match = matchesData.get(position);

        usernameTv.setText(match.name);
        descriptionTv.setText(match.description);

        return rowView;
    }

}