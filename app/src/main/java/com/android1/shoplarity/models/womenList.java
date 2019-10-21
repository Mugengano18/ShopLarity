package com.android1.shoplarity.models;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android1.shoplarity.Adapters.womenllistAdapter;
import com.android1.shoplarity.Apifolder.Category;
import com.android1.shoplarity.Apifolder.Location;
import com.android1.shoplarity.R;
import com.android1.shoplarity.network.Client;
import com.android1.shoplarity.network.Api;
import com.android1.shoplarity.Apifolder.Business;
import com.android1.shoplarity.Apifolder.Apiresponse;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class womenList extends AppCompatActivity {
    @BindView(R.id.listviewoman) ListView list1;
    private String[] womanlistt={"jeans","dress","trousers","skirts"};
    @BindView(R.id.progressBar1)
    ProgressBar bar1;
    @BindView(R.id.error)
    TextView error1;
    public static final String Tag =HomeActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_list);
        ButterKnife.bind(this);
//        womenllistAdapter womenllistAdapter=new womenllistAdapter(this,android.R.layout.simple_list_item_1, womenclothe, womanlistt);
//        list1.setAdapter(womenllistAdapter);
        Intent intent = getIntent();
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //the following codes are used to call objects from the ApiResponse
        Api clothe1= Client.getclient();
        Call<Apiresponse> call=clothe1.getCategory("women clothes","USA");
        call.enqueue(new Callback<Apiresponse>() {
            @Override
            public void onResponse(Call<Apiresponse> call, Response<Apiresponse> response) {
                hideProgressbar();
                if(response.isSuccessful()){
                    List<Business>womenlist = response.body().getBusinesses();
                    String[] womenclothe=new String[womenlist.size()];
                    String[] cat=new String[womenlist.size()];
                    String[] loc=new String[womenlist.size()];
                    String[] phone=new String[womenlist.size()];
                    String[]img=new String[womenlist.size()];
                    String[]rate=new String[womenlist.size()];

                    for (int i = 0; i < womenclothe.length; i++){
                        womenclothe[i] = womenlist.get(i).getName();
                    }
                    for (int i = 0; i < cat.length; i++){
                        Category categ = womenlist.get(i).getCategories().get(0);
                        cat[i] =categ.getTitle();
                    }
                    for (int i = 0; i < loc.length; i++){
                        Location locate=womenlist.get(i).getLocation();
                        loc[i] = locate.getAddress1();
                    }
                    for (int i = 0; i < phone.length; i++){
                        phone[i] = womenlist.get(i).getPhone();
                    }
                    for (int i = 0; i < img.length; i++){
                        img[i] = womenlist.get(i).getImageUrl();
                    }
                    for (int i = 0; i < rate.length; i++){
                        rate[i] = womenlist.get(i).getRating();
                    }
                    BaseAdapter adapter=new womenllistAdapter(womenclothe,cat,loc,phone,img,rate,womenList.this);
                    list1.setAdapter(adapter);

                    System.out.println(adapter);
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
        list1.setVisibility(View.VISIBLE);
    }

    private void hideProgressbar() {
        bar1.setVisibility(View.GONE);
    }
}
