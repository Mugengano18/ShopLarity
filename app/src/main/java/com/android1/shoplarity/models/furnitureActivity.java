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

import static com.android1.shoplarity.models.carsActivity.Tag;

public class furnitureActivity extends AppCompatActivity {
//    @BindView(R.id.listviewfurn)
//    ListView listviewfurn;
//    @BindView(R.id.progressBarfurn)
//    ProgressBar progressBarfurn;
//    @BindView(R.id.errorfurn)
//    TextView errorfurn;
//    public static final String Tag =HomeActivity.class.getSimpleName();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_furniture);
//        ButterKnife.bind(this);
//        Api furn= Client.getclient();
//        Call<Apiresponse> call=furn.getCategory("furniture","canada");
//        call.enqueue(new Callback<Apiresponse>() {
//            @Override
//            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
//                hideProgressbar();
//                if(response.isSuccessful()){
//                    List<Business> furnList = response.body().getBusinesses();
//                    String[] furns=new String[furnList.size()];
//
//                    for (int i = 0; i < furns.length; i++){
//                        furns[i] = furnList.get(i).getName();
//                    }
//                    BaseAdapter adapter=new carsAdapter(furnitureActivity.this,furns);
//                    listviewfurn.setAdapter(adapter);
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
//        errorfurn.setText("please check your connection");
//        errorfurn.setVisibility(View.VISIBLE);
//    }
//    private void showUnsuccessfulMessage() {
//        errorfurn.setText("Something went wrong. Please try again later");
//        errorfurn.setVisibility(View.VISIBLE);
//    }
//
//    private void showShoes() {
//        listviewfurn.setVisibility(View.VISIBLE);
//    }
//
//    private void hideProgressbar() {
//        progressBarfurn.setVisibility(View.GONE);
//    }


    @BindView(R.id.recycler_view1)
    RecyclerView recyclerView1;
    womenllistAdapter adapter;
    List<Business> furnLists;
    @BindView(R.id.progressBar1)
    ProgressBar bar1;
    @BindView(R.id.error)
    TextView error1;
    public static final String Tag =HomeActivity.class.getSimpleName();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_list);
        ButterKnife.bind(this);
        furnLists=new ArrayList<>();
        recyclerView1.setHasFixedSize(true);


        Api clothe1= Client.getclient();
        Call<Apiresponse> call=clothe1.getCategory("furniture","USA");
        call.enqueue(new Callback<Apiresponse>(){
            @Override
            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
                hideProgressbar();
                if(response.isSuccessful()){
                    furnLists = response.body().getBusinesses();
                    adapter=new womenllistAdapter(furnitureActivity.this,furnLists);
                    recyclerView1.setAdapter(adapter);
                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(furnitureActivity.this);
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
