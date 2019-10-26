package com.android1.shoplarity.models;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android1.shoplarity.Adapters.carsAdapter;
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

public class AntiquityActivity extends AppCompatActivity {
//    @BindView(R.id.listviewantique)
//    ListView listviewantique;
//    @BindView(R.id.progressBarantique)
//    ProgressBar progressBarantique;
//    @BindView(R.id.errorantique)
//    TextView errorantique;
//    public static final String Tag =HomeActivity.class.getSimpleName();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_antiquity);
//        ButterKnife.bind(this);
//        Api antique= Client.getclient();
//        Call<Apiresponse> call=antique.getCategory("antiquity","canada");
//        call.enqueue(new Callback<Apiresponse>() {
//            @Override
//            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
//                hideProgressbar();
//                if(response.isSuccessful()){
//                    List<Business> antiqueList = response.body().getBusinesses();
//                    String[] antiques=new String[antiqueList.size()];
//
//                    for (int i = 0; i < antiques.length; i++){
//                        antiques[i] = antiqueList.get(i).getName();
//                    }
//                    BaseAdapter adapter=new carsAdapter(AntiquityActivity.this,antiques);
//                    listviewantique.setAdapter(adapter);
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
//        errorantique.setText("please check your connection");
//        errorantique.setVisibility(View.VISIBLE);
//    }
//    private void showUnsuccessfulMessage() {
//        errorantique.setText("Something went wrong. Please try again later");
//        errorantique.setVisibility(View.VISIBLE);
//    }
//
//    private void showShoes() {
//        listviewantique.setVisibility(View.VISIBLE);
//    }
//
//    private void hideProgressbar() {
//        progressBarantique.setVisibility(View.GONE);
//    }

    @BindView(R.id.recycler_view1)
    RecyclerView recyclerView1;
    womenllistAdapter adapter;
    List<Business> antique;
    @BindView(R.id.progressBar1)
    ProgressBar bar1;
    @BindView(R.id.error)
    TextView error1;
    public static final String Tag =HomeActivity.class.getSimpleName();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_list);
        ButterKnife.bind(this);
        antique=new ArrayList<>();
        recyclerView1.setHasFixedSize(true);


        Api clothe1= Client.getclient();
        Call<Apiresponse> call=clothe1.getCategory("Antique","USA");
        call.enqueue(new Callback<Apiresponse>(){
            @Override
            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
                hideProgressbar();
                if(response.isSuccessful()){
                    antique = response.body().getBusinesses();
                    adapter=new womenllistAdapter(AntiquityActivity.this,antique);
                    recyclerView1.setAdapter(adapter);
                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(AntiquityActivity.this);
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
