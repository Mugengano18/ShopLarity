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

public class menadapter extends BaseAdapter {
    private String[] menClothes;
    private Context context;

    public menadapter(String[] menClothes, Context context) {
        this.context = context;
        this.menClothes = menClothes;
    }

    @Override
    public int getCount() {
        return menClothes.length;
    }

    @Override
    public Object getItem(int position) {
        return menClothes[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View men_view=convertView;

//        if(men_view==null){
//            LayoutInflater insert =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            men_view=insert.inflate(R.layout.menlist2,null);
//        }
//
//        TextView text=(TextView)men_view.findViewById(R.id.men1);
//        text.setText(menClothes[position]);
        return men_view;
    }
}
