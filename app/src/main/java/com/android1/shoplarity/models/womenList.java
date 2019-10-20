package com.android1.shoplarity.models;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android1.shoplarity.Adapters.womenllistAdapter;
import com.android1.shoplarity.R;
import com.android1.shoplarity.network.Client;
import com.android1.shoplarity.network.Api;
import com.android1.shoplarity.womenClothes.Business;
import com.android1.shoplarity.womenClothes.Apiresponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class womenList extends AppCompatActivity {
    @BindView(R.id.listviewoman) ListView list1;
    private String[] womanlistt={"jeans","dress","trousers","skirts"};
    @BindView(R.id.progressBar1)
    ProgressBar bar1;
    @BindView(R.id.error)
    TextView error1;
    public static final String Tag =HomeActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_list);
        ButterKnife.bind(this);
//        womenllistAdapter womenllistAdapter=new womenllistAdapter(this,android.R.layout.simple_list_item_1, womenclothe, womanlistt);
//        list1.setAdapter(womenllistAdapter);
        Intent intent = getIntent();

        Api clothe1= Client.getclient();
        Call<Apiresponse> call=clothe1.getCategory("women clothes","canada");
        call.enqueue(new Callback<Apiresponse>() {
            @Override
            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
                hideProgressbar();
                if(response.isSuccessful()){
                    List<Business>womenlist = response.body().getBusinesses();
                    String[] womenclothe=new String[womenlist.size()];

                    for (int i = 0; i < womenclothe.length; i++){
                        womenclothe[i] = womenlist.get(i).getName();
                    }
                    ArrayAdapter adapter=new womenllistAdapter(womenList.this,android.R.layout.simple_list_item_1,womenclothe);
                    list1.setAdapter(adapter);
                    System.out.println(adapter);
                    showClothes();
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
        error1.setText("please check your connection");
        error1.setVisibility(View.VISIBLE);
    }
    private void showUnsuccessfulMessage() {
        error1.setText("Something went wrong. Please try again later");
        error1.setVisibility(View.VISIBLE);
    }

    private void showClothes() {
        list1.setVisibility(View.VISIBLE);
    }

    private void hideProgressbar() {
        bar1.setVisibility(View.GONE);
    }
}