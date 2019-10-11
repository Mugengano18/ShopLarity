//package com.android1.shoplarity;
//
//import android.content.Context;
//import android.graphics.Typeface;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//public class nameAdapter extends BaseAdapter {
//    private Context context;
//    private String[] names;
//
//    public nameAdapter(Context context, String[] names, Typeface font) {
//        this.context = context;
//        this.names = names;
//        this.font = font;
//    }
//
//    private Typeface font;
//
//    @Override
//    public int getCount() {
//        return names.length;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater insertname=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View categoryname;
//        if(convertView==null){
//            categoryname=insertname.inflate(R.layout.description,null);
//            TextView description =(TextView) categoryname.findViewById(R.id.description);
//            description.setText(names[position]);
//            description.setTypeface(font);
//        }else{
//            categoryname= (View) convertView;
//        }
//        return categoryname;
//    }
//}
