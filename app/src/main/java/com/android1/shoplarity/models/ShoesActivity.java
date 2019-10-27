package com.android1.shoplarity.models;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android1.shoplarity.Adapters.womenllistAdapter;
import com.android1.shoplarity.Apifolder.Apiresponse;
import com.android1.shoplarity.Apifolder.Business;
import com.android1.shoplarity.R;
import com.android1.shoplarity.network.Api;
import com.android1.shoplarity.network.Client;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShoesActivity extends AppCompatActivity {
//    @BindView(R.id.listview2)
//    ListView shoeslist;
//    @BindView(R.id.progressBar5)
//    ProgressBar bar5;
//    @BindView(R.id.error5)
//    TextView error5;
//    public static final String Tag =HomeActivity.class.getSimpleName();
//    private String[] shoes={"Women's shoes","Men's Shoes","Children's Shoes"};
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_shoes);
//        ButterKnife.bind(this);
////        shoesAdapter shoesAdapter=new shoesAdapter(this,android.R.layout.simple_list_item_1,shoes);
////        shoeslist.setAdapter(shoesAdapter);
//
//        Api shoes= Client.getclient();
//        Call<Apiresponse> call=shoes.getCategory("shoes","canada");
//        call.enqueue(new Callback<Apiresponse>() {
//            @Override
//            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
//                hideProgressbar();
//                if(response.isSuccessful()){
//                    List<Business> shoelist = response.body().getBusinesses();
//                    String[] shoes=new String[shoelist.size()];
//
//                    for (int i = 0; i < shoes.length; i++){
//                        shoes[i] = shoelist.get(i).getName();
//                    }
//                    ArrayAdapter adapter=new shoesAdapter(ShoesActivity.this,android.R.layout.simple_list_item_1,shoes);
//                    shoeslist.setAdapter(adapter);
//                    System.out.println(adapter);
//                    showShoes();
//                }else {
//                    showUnsuccessfulMessage();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Apiresponse> call, Throwable t) {
//                Log.e(Tag,"onFailure:",t);
//                hideProgressbar();
//                failureSms();
//            }
//        });
//    }
//
//    private void failureSms(){
//        error5.setText("please check your connection");
//        error5.setVisibility(View.VISIBLE);
//    }
//    private void showUnsuccessfulMessage() {
//        error5.setText("Something went wrong. Please try again later");
//        error5.setVisibility(View.VISIBLE);
//    }
//
//    private void showShoes() {
//        shoeslist.setVisibility(View.VISIBLE);
//    }
//
//    private void hideProgressbar() {
//        bar5.setVisibility(View.GONE);
//    }

    @BindView(R.id.recycler_view1)
    RecyclerView recyclerView1;
    womenllistAdapter adapter;
    List<Business> shoes;
    @BindView(R.id.progressBar1)
    ProgressBar bar1;
    @BindView(R.id.error)
    TextView error1;
    public static final String Tag =HomeActivity.class.getSimpleName();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_list);
        ButterKnife.bind(this);
        shoes=new ArrayList<>();
        recyclerView1.setHasFixedSize(true);


        Api clothe1= Client.getclient();
        Call<Apiresponse> call=clothe1.getCategory("shoes","USA");
        call.enqueue(new Callback<Apiresponse>(){
            @Override
            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
                hideProgressbar();
                if(response.isSuccessful()){
                    shoes = response.body().getBusinesses();
                    adapter=new womenllistAdapter(ShoesActivity.this,shoes);
                    recyclerView1.setAdapter(adapter);
                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(ShoesActivity.this);
                    recyclerView1.setLayoutManager(layoutManager);
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
        recyclerView1.setVisibility(View.VISIBLE);
    }

    private void hideProgressbar() {
        bar1.setVisibility(View.GONE);
    }
    }

