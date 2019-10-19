package com.android1.shoplarity.models;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android1.shoplarity.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoesActivity extends AppCompatActivity {
    @BindView(R.id.listview2)
    ListView shoeslist;
    private String[] shoes={"Women's shoes","Men's Shoes","Children's Shoes"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes);
        ButterKnife.bind(this);
        shoesAdapter shoesAdapter=new shoesAdapter(this,android.R.layout.simple_list_item_1,shoes);
        shoeslist.setAdapter(shoesAdapter);

    }}
