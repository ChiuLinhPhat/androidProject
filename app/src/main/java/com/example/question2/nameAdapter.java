package com.example.question2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class nameAdapter extends ArrayAdapter<String> {
    public nameAdapter(@NonNull Context context, ArrayList<String> name) {
        super(context,0, name);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(name);

        return convertView;
    }

}
