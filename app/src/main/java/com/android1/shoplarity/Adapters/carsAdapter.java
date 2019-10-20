package com.android1.shoplarity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.android1.shoplarity.R;

public class carsAdapter extends BaseAdapter {
    Context context;
    private String[] cars;


    public carsAdapter(Context context, String[] cars) {
        this.context = context;
        this.cars = cars;
    }

    @Override
    public int getCount() {
        return cars.length;
    }

    @Override
    public Object getItem(int position) {
        return cars[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View car_view=convertView;

        if(car_view==null){
            LayoutInflater insert=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            car_view=insert.inflate(R.layout.carslist,null);
        }
        TextView text2=(TextView)car_view.findViewById(R.id.cars1);
        text2.setText(cars[position]);
        return car_view;
    }
}
