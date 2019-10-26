package com.android1.shoplarity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android1.shoplarity.R;

public class furnitureAdapter extends BaseAdapter {
    private Context context;
    private String[] furn;

    public furnitureAdapter(Context context, String[] furn) {
        this.context = context;
        this.furn = furn;
    }

    @Override
    public int getCount() {
        return furn.length;
    }

    @Override
    public Object getItem(int position) {
        return furn[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View furn_view=convertView;
        if(furn_view==null){
            LayoutInflater insert=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            furn_view=insert.inflate(R.layout.furniturelist,null);
        }
//        TextView text3=(TextView)furn_view.findViewById(R.id.furn);
//        text3.setText(furn[position]);
        return furn_view;
    }
}
