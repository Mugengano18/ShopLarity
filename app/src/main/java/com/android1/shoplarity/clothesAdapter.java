package com.android1.shoplarity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class clothesAdapter extends ArrayAdapter {
    Context context;
    private String clothes[];


    public clothesAdapter(@NonNull Context context, int resource,String[] clothes) {
        super(context, resource);
        this.context=context;
        this.clothes=clothes;
    }
    @Override
    public Object getItem(int position){
        String cloth=clothes[position];
        return String.format(cloth);
    }
    @Override
    public int getCount(){
        return clothes.length;
    }
}
