package com.android1.shoplarity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class carsActivity extends AppCompatActivity {
    @BindView(R.id.listview3)
    ListView carslist;
    private String[] cars={"Microcar","Economy hatchback","Sedan","Coupe","Sports cars","Convertibles","SUVs","Pickup","Crossover","Estate cars","Modified cars"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);
        ButterKnife.bind(this);
        carsAdapter carsAdapter=new carsAdapter(this,android.R.layout.simple_list_item_1,cars);
        carslist.setAdapter(carsAdapter);
    }
}
