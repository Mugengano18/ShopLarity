package com.android1.shoplarity.Adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class womenllistAdapter extends ArrayAdapter {
    private String[] womenclothess;
    private Context context;


    public womenllistAdapter(@NonNull Context context, int resource, String[] womenclothess) {
        super(context, resource);
        this.context=context;
        this.womenclothess=womenclothess;
    }

    @Override
    public Object getItem(int position){
        String women=womenclothess[position];
        return women;
    }
    @Override
    public int getCount(){
        return womenclothess.length;
    }
}
