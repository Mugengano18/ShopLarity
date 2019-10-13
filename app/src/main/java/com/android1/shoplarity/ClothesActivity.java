package com.android1.shoplarity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClothesActivity extends AppCompatActivity {
    @BindView(R.id.listview1)
    ListView clotheslist;
    private String[] clothes={"Women's clothes","Men's clothes","Children's clothes"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        ButterKnife.bind(this);
        clothesAdapter clothesAdapter=new clothesAdapter(this,android.R.layout.simple_list_item_1,clothes);
        clotheslist.setAdapter(clothesAdapter);//this is used to show the list of clothes
        clotheslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clothe = ((TextView)view).getText().toString();
                Toast.makeText(ClothesActivity.this,clothe,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
