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

public class childrenList extends AppCompatActivity {
//    @BindView(R.id.listchildren)
//    ListView children;
//    @BindView(R.id.error4)
//    TextView error4;
//    @BindView(R.id.progressBar4)
//    ProgressBar bar4;
//    public static final String Tag =HomeActivity.class.getSimpleName();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_children_list);
//        ButterKnife.bind(this);
//        Api clothe3= Client.getclient();
//        Call<Apiresponse> call=clothe3.getCategory("children clothes","canada");
//        call.enqueue(new Callback<Apiresponse>() {
//            @Override
//            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
//                hideProgressbar();
//                String[] childrenclothe;
//                if (response.isSuccessful()) {
//                    List<Business> childrenlist = response.body().getBusinesses();
//                    childrenclothe = new String[childrenlist.size()];
//
//                    for (int i = 0; i < childrenclothe.length; i++) {
//                        childrenclothe[i] = childrenlist.get(i).getName();
//                    }
//                    BaseAdapter adapter = new menadapter(childrenclothe, childrenList.this);
//                    children.setAdapter(adapter);
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
//        error4.setText("please check your connection");
//        error4.setVisibility(View.VISIBLE);
//    }
//    private void showUnsuccessfulMessage() {
//        error4.setText("Something went wrong. Please try again later");
//        error4.setVisibility(View.VISIBLE);
//    }
//
//    private void showClothes() {
//        children.setVisibility(View.VISIBLE);
//    }
//
//    private void hideProgressbar() {
//        bar4.setVisibility(View.GONE);
//    }

    @BindView(R.id.recycler_view1)
    RecyclerView recyclerView1;
    womenllistAdapter adapter;
    List<Business> childLists;
    @BindView(R.id.progressBar1)
    ProgressBar bar1;
    @BindView(R.id.error)
    TextView error1;
    public static final String Tag =HomeActivity.class.getSimpleName();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_list);
        ButterKnife.bind(this);
        childLists=new ArrayList<>();
        recyclerView1.setHasFixedSize(true);


        Api clothe1= Client.getclient();
        Call<Apiresponse> call=clothe1.getCategory("children clothes","USA");
        call.enqueue(new Callback<Apiresponse>(){
            @Override
            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
                hideProgressbar();
                if(response.isSuccessful()){
                    childLists = response.body().getBusinesses();
                    adapter=new womenllistAdapter(childrenList.this,childLists);
                    recyclerView1.setAdapter(adapter);
                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(childrenList.this);
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
