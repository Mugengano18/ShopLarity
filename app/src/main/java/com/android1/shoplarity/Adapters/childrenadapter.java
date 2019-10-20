package com.android1.shoplarity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android1.shoplarity.R;

public class childrenadapter extends BaseAdapter {
    private Context context;
    private String[] childrenclo;

    public childrenadapter(Context context, String[] childrenclo) {
        this.context = context;
        this.childrenclo = childrenclo;
    }

    @Override
    public int getCount() {
        return childrenclo.length;
    }

    @Override
    public Object getItem(int position) {
        return childrenclo[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View child=convertView;
        if(child==null){
            LayoutInflater insert=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child=insert.inflate(R.layout.childrenlist,null);
        }
        TextView text2=(TextView)child.findViewById(R.id.child1);
        text2.setText(childrenclo[position]);
        return child;
    }
}
