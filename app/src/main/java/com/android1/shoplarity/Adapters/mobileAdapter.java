package com.android1.shoplarity.Adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class mobileAdapter extends ArrayAdapter {//the array adapter is used different to the base adapter
    Context context;
    private String[] cell;

    public mobileAdapter(@NonNull Context context, int resource, String[] cell) {
        super(context, resource);
        this.context = context;
        this.cell = cell;
    }
    @Override
    public Object getItem(int position){
        String cellph=cell[position];
        return String.format(cellph);
    }
    @Override
    public int getCount(){
        return cell.length;
    }
}
