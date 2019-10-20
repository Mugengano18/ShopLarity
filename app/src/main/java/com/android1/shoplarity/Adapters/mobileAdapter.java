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

public class mobileAdapter extends BaseAdapter {//the array adapter is used different to the base adapter
    Context context;
    private String[] cell;


    public mobileAdapter(Context context, String[] cell) {
        this.context = context;
        this.cell = cell;
    }

    @Override
    public int getCount() {
        return cell.length;
    }

    @Override
    public Object getItem(int position) {
        return cell[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View cell_view=convertView;
        if(cell_view==null){
            LayoutInflater insert=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            cell_view=insert.inflate(R.layout.mobilelist,null);
        }
        TextView mobile=(TextView)cell_view.findViewById(R.id.mobi);
        mobile.setText(cell[position]);
        return cell_view;
    }
}
