package com.android1.shoplarity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class categoryAdapter extends BaseAdapter {
    Context context;
    private int[] foto_id={R.drawable.foto1,R.drawable.foto2,R.drawable.foto3,R.drawable.foto4,R.drawable.foto5,R.drawable.foto6,R.drawable.foto7};

    categoryAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return foto_id.length;
    }

    @Override
    public Object getItem(int position) {
        return foto_id[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View foto_view=convertView;
        if (foto_view==null){
            LayoutInflater insert=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            foto_view=insert.inflate(R.layout.categoryitems,null);

        }

        ImageView image=(ImageView)foto_view.findViewById(R.id.foto);
        image.setImageResource(foto_id[position]);
        return foto_view;
    }
}
