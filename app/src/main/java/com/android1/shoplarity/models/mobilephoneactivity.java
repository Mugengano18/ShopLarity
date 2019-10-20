package com.android1.shoplarity.models;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android1.shoplarity.Adapters.carsAdapter;
import com.android1.shoplarity.Apifolder.Apiresponse;
import com.android1.shoplarity.Apifolder.Business;
import com.android1.shoplarity.R;
import com.android1.shoplarity.Adapters.mobileAdapter;
import com.android1.shoplarity.network.Api;
import com.android1.shoplarity.network.Client;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class mobilephoneactivity extends AppCompatActivity {
    @BindView(R.id.listviewphone)
    ListView phonelist;
    @BindView(R.id.progressBarphone)
    ProgressBar progressBarphone;
    @BindView(R.id.errorphone)
    TextView errorphone;
    public static final String Tag =HomeActivity.class.getSimpleName();
    private String[]phone={"Samsung","iPhone","Huawei","Nokia"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobilephoneactivity);
        ButterKnife.bind(this);
//        mobileAdapter mobileAdapter=new mobileAdapter(this,android.R.layout.simple_list_item_1,phone);
//        phones.setAdapter(mobileAdapter);

        Api cell= Client.getclient();
        Call<Apiresponse> call=cell.getCategory("phones","canada");
        call.enqueue(new Callback<Apiresponse>() {
            @Override
            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
                hideProgressbar();
                if(response.isSuccessful()){
                    List<Business> cellList = response.body().getBusinesses();
                    String[] phones=new String[cellList.size()];

                    for (int i = 0; i < phones.length; i++){
                        phones[i] = cellList.get(i).getName();
                    }
                    BaseAdapter adapter=new carsAdapter(mobilephoneactivity.this,phones);
                    phonelist.setAdapter(adapter);
                    System.out.println(adapter);
                    showShoes();
                }else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<Apiresponse> call, Throwable t) {
                Log.e(Tag,"onFailure:",t);
                hideProgressbar();
                failureSms();
            }
        });
    }

    private void failureSms(){
        errorphone.setText("please check your connection");
        errorphone.setVisibility(View.VISIBLE);
    }
    private void showUnsuccessfulMessage() {
        errorphone.setText("Something went wrong. Please try again later");
        errorphone.setVisibility(View.VISIBLE);
    }

    private void showShoes() {
        phonelist.setVisibility(View.VISIBLE);
    }

    private void hideProgressbar() {
        progressBarphone.setVisibility(View.GONE);
    }


}
