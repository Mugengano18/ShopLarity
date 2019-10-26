package com.android1.shoplarity.models;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;

import com.android1.shoplarity.Adapters.clothespagerAdapter;
import com.android1.shoplarity.Apifolder.Business;
import com.android1.shoplarity.R;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class clothedetails extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private clothespagerAdapter  adapter;
    List<Business> clothes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothedetails);
        ButterKnife.bind(this);

        clothes= Parcels.unwrap(getIntent().getParcelableExtra("clothes"));
        int sPosition=getIntent().getIntExtra("Pos",0);

        adapter=new clothespagerAdapter(getSupportFragmentManager(),clothes);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(sPosition);
    }
}
