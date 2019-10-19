package com.android1.shoplarity.Adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class carsAdapter extends ArrayAdapter {
    Context context;
    private String[] cars;

    public carsAdapter(@NonNull Context context, int resource, String[] cars) {
        super(context, resource);
        this.context = context;
        this.cars = cars;
    }
    @Override
    public Object getItem(int position){
        String car=cars[position];
        return String.format(car);
    }
    @Override
    public int getCount(){
        return cars.length;
    }
}
