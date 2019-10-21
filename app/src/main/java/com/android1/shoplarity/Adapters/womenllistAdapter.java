package com.android1.shoplarity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android1.shoplarity.R;
import com.squareup.picasso.Picasso;



public class womenllistAdapter extends BaseAdapter {
    private String[] womenclothess;
    private String[] wCategory;
    private String[] wLocation;
    private String[] wPhone;
    private String[] wRating;
    private  String[] wImageview;
    private Context context;




    public womenllistAdapter(String[] womenclothess, String[] wCategory, String[] wLocation, String[] wPhone, String[] wImageview, String[] wRating, Context context) {
        this.womenclothess = womenclothess;
        this.wCategory = wCategory;
        this.wLocation = wLocation;
        this.wPhone = wPhone;
        this.wRating = wRating;
        this.wImageview = wImageview;
        this.context = context;
    }



    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return womenclothess.length;
    }

    @Override
    public Object getItem(int position) {
        return womenclothess[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View woman_view=null;
        if(woman_view==null){
            LayoutInflater insert=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            woman_view=insert.inflate(R.layout.womanlist,null);
        }
        TextView text5=(TextView)woman_view.findViewById(R.id.woman);
        text5.setText(womenclothess[position]);
        TextView cat=(TextView)woman_view.findViewById(R.id.woman1);
        cat.setText(wCategory[position]);
        TextView loc=(TextView)woman_view.findViewById(R.id.woman2);
        loc.setText(wLocation[position]);
        TextView phone=(TextView)woman_view.findViewById(R.id.woman3);
        phone.setText(wPhone[position]);
        TextView rate=(TextView)woman_view.findViewById(R.id.woman4);
        rate.setText( "rate:"+wRating[position]);
        ImageView image1=(ImageView)woman_view.findViewById(R.id.womanImg);

        Picasso.get().load(wImageview[position]).into(image1);//this is done by the Technical mentor
        return woman_view;
    }

}
