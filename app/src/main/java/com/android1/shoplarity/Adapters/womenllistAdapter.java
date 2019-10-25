package com.android1.shoplarity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android1.shoplarity.Apifolder.Business;
import com.android1.shoplarity.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


//public class womenllistAdapter extends BaseAdapter {
//    private String[] womenclothess;
//    private String[] wCategory;
//    private String[] wLocation;
//    private String[] wPhone;
//    private String[] wRating;
//    private  String[] wImageview;
//    private Context context;
//
//
//
//
//    public womenllistAdapter(String[] womenclothess, String[] wCategory, String[] wLocation, String[] wPhone, String[] wImageview, String[] wRating, Context context) {
//        this.womenclothess = womenclothess;
//        this.wCategory = wCategory;
//        this.wLocation = wLocation;
//        this.wPhone = wPhone;
//        this.wRating = wRating;
//        this.wImageview = wImageview;
//        this.context = context;
//    }
//
//
//
//    public Context getContext() {
//        return context;
//    }
//
//    public void setContext(Context context) {
//        this.context = context;
//    }
//
//    @Override
//    public int getCount() {
//        return womenclothess.length;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return womenclothess[position];
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View woman_view=null;
//        if(woman_view==null){
//            LayoutInflater insert=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            woman_view=insert.inflate(R.layout.womanlist,null);
//        }
//        TextView text5=(TextView)woman_view.findViewById(R.id.woman);
//        text5.setText(womenclothess[position]);
//        TextView cat=(TextView)woman_view.findViewById(R.id.woman1);
//        cat.setText(wCategory[position]);
//        TextView loc=(TextView)woman_view.findViewById(R.id.woman2);
//        loc.setText(wLocation[position]);
//        TextView phone=(TextView)woman_view.findViewById(R.id.woman3);
//        phone.setText(wPhone[position]);
//        TextView rate=(TextView)woman_view.findViewById(R.id.woman4);
//        rate.setText( "rate:"+wRating[position]);
//        ImageView image1=(ImageView)woman_view.findViewById(R.id.womanImg);
//
//        Picasso.get().load(wImageview[position]).into(image1);//this is done by the Technical mentor
//        return woman_view;
//    }
//
//}
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//this is the second version of my codes


public class womenllistAdapter extends RecyclerView.Adapter<womenllistAdapter.womanViewHolder>{
    private Context context;
    private List<Business> womenclothess;

    public womenllistAdapter(Context context, List<Business> womenclothess) {
        this.context = context;
        this.womenclothess = womenclothess;
    }

    @NonNull
    @Override
    public womanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater insert=LayoutInflater.from(context);
        View v=insert.inflate(R.layout.womanlist,null);
        womanViewHolder wHolder= new womanViewHolder(v);
        return wHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull womanViewHolder holder, int position) {
        holder.bindList(womenclothess.get(position));

    }

    @Override
    public int getItemCount() {
        return womenclothess.size();
    }

    class womanViewHolder extends RecyclerView.ViewHolder{
        //creating the ui elemnt
        @BindView(R.id.womanImg) ImageView image1;
        @BindView(R.id.storename)TextView text5;
        @BindView(R.id.category)TextView cat;
        @BindView(R.id.location)TextView loc;
        @BindView(R.id.phonen)TextView phone;
        @BindView(R.id.rate)TextView rate;

        private Context context;
        public womanViewHolder(@NonNull View itemView) {
            super(itemView);
            //accessing the views from itemview
            ButterKnife.bind(this,itemView);
            context=itemView.getContext();

        }


        public void bindList(Business business) {
            text5.setText(business.getName());
            cat.setText(business.getCategories().get(0).getTitle());
            loc.setText(business.getLocation().getAddress1());
            phone.setText(business.getPhone());
            rate.setText("rate " + String.valueOf(business.getRating()));
            Picasso.get().load(business.getImageUrl()).into(image1);
        }
    }



}
