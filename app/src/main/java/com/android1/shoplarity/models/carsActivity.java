package com.android1.shoplarity.models;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android1.shoplarity.Adapters.carsAdapter;
import com.android1.shoplarity.R;

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
        carslist=(ListView)findViewById(R.id.listview3);
        carsAdapter carsAdapter=new carsAdapter(this,android.R.layout.simple_list_item_1,cars);
        carslist.setAdapter(carsAdapter);
    }
}
