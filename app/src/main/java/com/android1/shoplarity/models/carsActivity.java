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

public class carsActivity extends AppCompatActivity {
//    @BindView(R.id.listviewcars)
//    ListView carslist;
//    @BindView(R.id.progressBarcars)
//    ProgressBar progressBarcars;
//    @BindView(R.id.errorcars)
//    TextView errorcars;
//    public static final String Tag =HomeActivity.class.getSimpleName();
//    private String[] cars={"Microcar","Economy hatchback","Sedan","Coupe","Sports cars","Convertibles","SUVs","Pickup","Crossover","Estate cars","Modified cars"};
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_cars);
//        ButterKnife.bind(this);
//        carslist=(ListView)findViewById(R.id.listviewcars);
//        Api cars= Client.getclient();
//        Call<Apiresponse> call=cars.getCategory("cars","canada");
//        call.enqueue(new Callback<Apiresponse>() {
//            @Override
//            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
//                hideProgressbar();
//                if(response.isSuccessful()){
//                    List<Business> carlist = response.body().getBusinesses();
//                    String[] cars=new String[carlist.size()];
//
//                    for (int i = 0; i < cars.length; i++){
//                        cars[i] = carlist.get(i).getName();
//                    }
//                    BaseAdapter adapter=new carsAdapter(carsActivity.this,cars);
//                    carslist.setAdapter(adapter);
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
//        errorcars.setText("please check your connection");
//        errorcars.setVisibility(View.VISIBLE);
//    }
//    private void showUnsuccessfulMessage() {
//        errorcars.setText("Something went wrong. Please try again later");
//        errorcars.setVisibility(View.VISIBLE);
//    }
//
//    private void showShoes() {
//        carslist.setVisibility(View.VISIBLE);
//    }
//
//    private void hideProgressbar() {
//        progressBarcars.setVisibility(View.GONE);
//    }

    @BindView(R.id.recycler_view1)
    RecyclerView recyclerView1;
    womenllistAdapter adapter;
    List<Business> carLists;
    @BindView(R.id.progressBar1)
    ProgressBar bar1;
    @BindView(R.id.error)
    TextView error1;
    public static final String Tag =HomeActivity.class.getSimpleName();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_list);
        ButterKnife.bind(this);
        carLists=new ArrayList<>();
        recyclerView1.setHasFixedSize(true);


        Api clothe1= Client.getclient();
        Call<Apiresponse> call=clothe1.getCategory("cars","USA");
        call.enqueue(new Callback<Apiresponse>(){
            @Override
            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
                hideProgressbar();
                if(response.isSuccessful()){
                    carLists = response.body().getBusinesses();
                    adapter=new womenllistAdapter(carsActivity.this,carLists);
                    recyclerView1.setAdapter(adapter);
                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(carsActivity.this);
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
