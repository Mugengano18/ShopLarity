package com.android1.shoplarity.models;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class shoesAdapter extends ArrayAdapter {
    Context context;
    private String[] shoes;

    public shoesAdapter(@NonNull Context context, int resource, String[] shoes) {
        super(context, resource);
        this.context = context;
        this.shoes = shoes;
    }

    @Override
    public Object getItem(int position){
        String shoe=shoes[position];
        return String.format(shoe);
    }
    @Override
    public int getCount(){
        return shoes.length;
    }
}
