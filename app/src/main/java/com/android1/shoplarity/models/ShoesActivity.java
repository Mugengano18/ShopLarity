package com.android1.shoplarity.models;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android1.shoplarity.Adapters.shoesAdapter;
import com.android1.shoplarity.Adapters.womenllistAdapter;
import com.android1.shoplarity.Apifolder.Apiresponse;
import com.android1.shoplarity.Apifolder.Business;
import com.android1.shoplarity.R;
import com.android1.shoplarity.network.Api;
import com.android1.shoplarity.network.Client;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShoesActivity extends AppCompatActivity {
    @BindView(R.id.listview2)
    ListView shoeslist;
    @BindView(R.id.progressBar5)
    ProgressBar bar5;
    @BindView(R.id.error5)
    TextView error5;
    public static final String Tag =HomeActivity.class.getSimpleName();
    private String[] shoes={"Women's shoes","Men's Shoes","Children's Shoes"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes);
        ButterKnife.bind(this);
//        shoesAdapter shoesAdapter=new shoesAdapter(this,android.R.layout.simple_list_item_1,shoes);
//        shoeslist.setAdapter(shoesAdapter);

        Api shoes= Client.getclient();
        Call<Apiresponse> call=shoes.getCategory("shoes","canada");
        call.enqueue(new Callback<Apiresponse>() {
            @Override
            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
                hideProgressbar();
                if(response.isSuccessful()){
                    List<Business> shoelist = response.body().getBusinesses();
                    String[] shoes=new String[shoelist.size()];

                    for (int i = 0; i < shoes.length; i++){
                        shoes[i] = shoelist.get(i).getName();
                    }
                    ArrayAdapter adapter=new shoesAdapter(ShoesActivity.this,android.R.layout.simple_list_item_1,shoes);
                    shoeslist.setAdapter(adapter);
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
        error5.setText("please check your connection");
        error5.setVisibility(View.VISIBLE);
    }
    private void showUnsuccessfulMessage() {
        error5.setText("Something went wrong. Please try again later");
        error5.setVisibility(View.VISIBLE);
    }

    private void showShoes() {
        shoeslist.setVisibility(View.VISIBLE);
    }

    private void hideProgressbar() {
        bar5.setVisibility(View.GONE);
    }
    }

