package com.android1.shoplarity.models;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android1.shoplarity.Adapters.womenllistAdapter;
import com.android1.shoplarity.Apifolder.Business;
import com.android1.shoplarity.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;

public class Singleinfo extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.store)
    TextView storeName;
    @BindView(R.id.cat)TextView cate;
    @BindView(R.id.rate)TextView rate;
    @BindView(R.id.image2)
    ImageView image4;
    @BindView(R.id.websiteTextView)TextView website;
    @BindView(R.id.PhoneText)TextView phone;
    @BindView(R.id.ExactLocation)TextView location;
    @BindView(R.id.saveButton)
    Button favorite;
    @BindView(R.id.help)Button help;
    public Business clothes;
    womenllistAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleinfo);
        Intent intent = getIntent();


    }

    @Override
    public void onClick(View v) {
        if (v == website) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(clothes.getUrl()));
            startActivity(webIntent);
        }
        if (v == phone) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + clothes.getPhone()));
            startActivity(phoneIntent);
        }
        if (v == location) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:" + clothes.getCoordinates().getLatitude()
                            + "," + clothes.getCoordinates().getLongitude()
                            + "?q=(" + clothes.getName() + ")"));
            startActivity(mapIntent);
        }
    }
}
