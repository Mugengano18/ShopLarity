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
import com.android1.shoplarity.network.Api;
import com.android1.shoplarity.network.Client;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.android1.shoplarity.models.carsActivity.Tag;

public class furnitureActivity extends AppCompatActivity {
    @BindView(R.id.listviewfurn)
    ListView listviewfurn;
    @BindView(R.id.progressBarfurn)
    ProgressBar progressBarfurn;
    @BindView(R.id.errorfurn)
    TextView errorfurn;
    public static final String Tag =HomeActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture);
        ButterKnife.bind(this);
        Api furn= Client.getclient();
        Call<Apiresponse> call=furn.getCategory("furniture","canada");
        call.enqueue(new Callback<Apiresponse>() {
            @Override
            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
                hideProgressbar();
                if(response.isSuccessful()){
                    List<Business> furnList = response.body().getBusinesses();
                    String[] furns=new String[furnList.size()];

                    for (int i = 0; i < furns.length; i++){
                        furns[i] = furnList.get(i).getName();
                    }
                    BaseAdapter adapter=new carsAdapter(furnitureActivity.this,furns);
                    listviewfurn.setAdapter(adapter);
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
        errorfurn.setText("please check your connection");
        errorfurn.setVisibility(View.VISIBLE);
    }
    private void showUnsuccessfulMessage() {
        errorfurn.setText("Something went wrong. Please try again later");
        errorfurn.setVisibility(View.VISIBLE);
    }

    private void showShoes() {
        listviewfurn.setVisibility(View.VISIBLE);
    }

    private void hideProgressbar() {
        progressBarfurn.setVisibility(View.GONE);
    }

}
