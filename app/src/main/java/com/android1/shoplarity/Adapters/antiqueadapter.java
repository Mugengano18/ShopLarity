package com.android1.shoplarity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android1.shoplarity.R;

public class antiqueadapter extends BaseAdapter {
    private Context context;
    private String[] antique;

    public antiqueadapter(Context context, String[] antique) {
        this.context = context;
        this.antique = antique;
    }

    @Override
    public int getCount() {
        return antique.length;
    }

    @Override
    public Object getItem(int position) {
        return antique[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View antiqe_view=null;
        if(antiqe_view==null){
            LayoutInflater insert=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            antiqe_view=insert.inflate(R.layout.antiquelist,null);
        }
        TextView text5=(TextView)antiqe_view.findViewById(R.id.antique);
        text5.setText(antique[position]);
        return antiqe_view;
    }
}
