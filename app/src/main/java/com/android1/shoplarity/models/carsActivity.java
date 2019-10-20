package com.android1.shoplarity.models;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android1.shoplarity.Adapters.carsAdapter;
import com.android1.shoplarity.Adapters.shoesAdapter;
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

public class carsActivity extends AppCompatActivity {
    @BindView(R.id.listviewcars)
    ListView carslist;
    @BindView(R.id.progressBarcars)
    ProgressBar progressBarcars;
    @BindView(R.id.errorcars)
    TextView errorcars;
    public static final String Tag =HomeActivity.class.getSimpleName();
    private String[] cars={"Microcar","Economy hatchback","Sedan","Coupe","Sports cars","Convertibles","SUVs","Pickup","Crossover","Estate cars","Modified cars"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);
        ButterKnife.bind(this);
        carslist=(ListView)findViewById(R.id.listviewcars);
        Api shoes= Client.getclient();
        Call<Apiresponse> call=shoes.getCategory("cars","canada");
        call.enqueue(new Callback<Apiresponse>() {
            @Override
            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
                hideProgressbar();
                if(response.isSuccessful()){
                    List<Business> carlist = response.body().getBusinesses();
                    String[] cars=new String[carlist.size()];

                    for (int i = 0; i < cars.length; i++){
                        cars[i] = carlist.get(i).getName();
                    }
                    BaseAdapter adapter=new carsAdapter(carsActivity.this,cars);
                    carslist.setAdapter(adapter);
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
        errorcars.setText("please check your connection");
        errorcars.setVisibility(View.VISIBLE);
    }
    private void showUnsuccessfulMessage() {
        errorcars.setText("Something went wrong. Please try again later");
        errorcars.setVisibility(View.VISIBLE);
    }

    private void showShoes() {
        carslist.setVisibility(View.VISIBLE);
    }

    private void hideProgressbar() {
        progressBarcars.setVisibility(View.GONE);
    }

}
