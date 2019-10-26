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

import com.android1.shoplarity.Adapters.menadapter;
import com.android1.shoplarity.Adapters.womenllistAdapter;
import com.android1.shoplarity.R;
import com.android1.shoplarity.network.Api;
import com.android1.shoplarity.network.Client;
import com.android1.shoplarity.Apifolder.Apiresponse;
import com.android1.shoplarity.Apifolder.Business;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenList extends AppCompatActivity {
//    @BindView(R.id.listviewmen)
//    ListView menlist2;
//    @BindView(R.id.error3)
//    TextView error3;
//    @BindView(R.id.progressBar2)
//    ProgressBar bar2;
//    public static final String Tag =HomeActivity.class.getSimpleName();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_men_list);
//        ButterKnife.bind(this);
//
//        Api clothe2= Client.getclient();
//        Call<Apiresponse>call=clothe2.getCategory("men clothes","canada");
//        call.enqueue(new Callback<Apiresponse>() {
//            @Override
//            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
//                hideProgressbar();
//                String[] mencloth;
//                if (response.isSuccessful()) {
//                    List<Business> menlist = response.body().getBusinesses();
//                    mencloth = new String[menlist.size()];
//
//                    for (int i = 0; i < mencloth.length; i++) {
//                        mencloth[i] = menlist.get(i).getName();
//                    }
//                    BaseAdapter adapter = new menadapter(mencloth, MenList.this);
//                    menlist2.setAdapter(adapter);
//                    showClothes();
//                }else {
//                    showUnsuccessfulMessage();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<Apiresponse> call, Throwable t) {
//                Log.e(Tag,"onFailure:",t);
//                hideProgressbar();
//                failureSms();
//
//            }
//        });
//    }
//
//
//    private void failureSms(){
//        error3.setText("please check your connection");
//        error3.setVisibility(View.VISIBLE);
//    }
//    private void showUnsuccessfulMessage() {
//        error3.setText("Something went wrong. Please try again later");
//        error3.setVisibility(View.VISIBLE);
//    }
//
//    private void showClothes() {
//        menlist2.setVisibility(View.VISIBLE);
//    }
//
//    private void hideProgressbar() {
//        bar2.setVisibility(View.GONE);
//    }

    @BindView(R.id.recycler_view1)
    RecyclerView recyclerView1;
    womenllistAdapter adapter;
    List<Business> menLists;
    @BindView(R.id.progressBar1)
    ProgressBar bar1;
    @BindView(R.id.error)
    TextView error1;
    public static final String Tag =HomeActivity.class.getSimpleName();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_list);
        ButterKnife.bind(this);
        menLists=new ArrayList<>();
        recyclerView1.setHasFixedSize(true);


        Api clothe1= Client.getclient();
        Call<Apiresponse> call=clothe1.getCategory("men clothes","USA");
        call.enqueue(new Callback<Apiresponse>(){
            @Override
            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
                hideProgressbar();
                if(response.isSuccessful()){
                    menLists = response.body().getBusinesses();
                    adapter=new womenllistAdapter(MenList.this,menLists);
                    recyclerView1.setAdapter(adapter);
                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(MenList.this);
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
