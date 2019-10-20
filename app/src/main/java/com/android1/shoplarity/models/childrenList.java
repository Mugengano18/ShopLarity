package com.android1.shoplarity.models;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android1.shoplarity.Adapters.menadapter;
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

public class childrenList extends AppCompatActivity {
    @BindView(R.id.listchildren)
    ListView children;
    @BindView(R.id.error4)
    TextView error4;
    @BindView(R.id.progressBar4)
    ProgressBar bar4;
    public static final String Tag =HomeActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children_list);
        ButterKnife.bind(this);
        Api clothe3= Client.getclient();
        Call<Apiresponse> call=clothe3.getCategory("children clothes","canada");
        call.enqueue(new Callback<Apiresponse>() {
            @Override
            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
                hideProgressbar();
                String[] childrenclothe;
                if (response.isSuccessful()) {
                    List<Business> childrenlist = response.body().getBusinesses();
                    childrenclothe = new String[childrenlist.size()];

                    for (int i = 0; i < childrenclothe.length; i++) {
                        childrenclothe[i] = childrenlist.get(i).getName();
                    }
                    BaseAdapter adapter = new menadapter(childrenclothe, childrenList.this);
                    children.setAdapter(adapter);
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
        error4.setText("please check your connection");
        error4.setVisibility(View.VISIBLE);
    }
    private void showUnsuccessfulMessage() {
        error4.setText("Something went wrong. Please try again later");
        error4.setVisibility(View.VISIBLE);
    }

    private void showClothes() {
        children.setVisibility(View.VISIBLE);
    }

    private void hideProgressbar() {
        bar4.setVisibility(View.GONE);
    }

}
