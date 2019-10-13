package com.android1.shoplarity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class mobilephoneactivity extends AppCompatActivity {
    @BindView(R.id.listview4)
    ListView phones;
    private String[]phone={"Samsung","iPhone","Huawei","Nokia"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobilephoneactivity);
        ButterKnife.bind(this);
        phones=(ListView)findViewById(R.id.listview4);
        mobileAdapter mobileAdapter=new mobileAdapter(this,android.R.layout.simple_list_item_1,phone);
        phones.setAdapter(mobileAdapter);
    }
}
