package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StateAdapter extends ArrayAdapter<Cars>{
    private LayoutInflater inflater;
    private int layout;
    private List<Cars> cars;

    public StateAdapter(Context context, int resource, List<Cars> states) {
        super(context, resource, states);
        this.cars = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView flagView = view.findViewById(R.id.carsIMG);
        TextView nameView = view.findViewById(R.id.name);
        TextView capitalView = view.findViewById(R.id.comment);

        Cars state = cars.get(position);

        flagView.setImageResource(state.getCarsIMG());
        nameView.setText(state.getName());
        capitalView.setText(state.getComment());

        return view;
    }
}
