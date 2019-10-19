package com.android1.shoplarity.models;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android1.shoplarity.R;
import com.android1.shoplarity.Adapters.mobileAdapter;

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
        mobileAdapter mobileAdapter=new mobileAdapter(this,android.R.layout.simple_list_item_1,phone);
        phones.setAdapter(mobileAdapter);
    }
}
