package com.android1.shoplarity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView imageGrid;
    ArrayList category=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageGrid=(GridView)findViewById(R.id.grid1);

        categoryAdapter imgadapter = new categoryAdapter(this);
        imageGrid.setAdapter(imgadapter);
    }
}
