package com.android1.shoplarity.models;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android1.shoplarity.Apifolder.Business;
import com.android1.shoplarity.Apifolder.Category;
import com.android1.shoplarity.R;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WomenDetailFragment extends Fragment implements View.OnClickListener{

    @BindView(R.id.image2)
    ImageView image2;
    @BindView(R.id.store)
    TextView store;
    @BindView(R.id.cat)
    TextView cate;
    @BindView(R.id.rate)TextView rate;
    @BindView(R.id.websiteTextView)TextView website;
    @BindView(R.id.PhoneText) TextView phone;
    @BindView(R.id.ExactLocation)TextView location;
    @BindView(R.id.saveButton)Button fav;
    @BindView(R.id.help)
    Button help;
    public Business clothes;

    public WomenDetailFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static WomenDetailFragment newInstance(Business clothe) {
        WomenDetailFragment fragment = new WomenDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("cloth", Parcels.wrap(clothe));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        clothes=Parcels.unwrap(getArguments().getParcelable("cloth"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_women_detail,container,false);
        ButterKnife.bind(this,v);
        Picasso.get().load(clothes.getImageUrl()).into(image2);
        List<String>cat=new ArrayList<>();
        for (Category category:clothes.getCategories()){
            cat.add(category.getTitle());
        }
        store.setText(clothes.getName());
        cate.setText(clothes.getCategories().get(0).getTitle());
        rate.setText(String.valueOf(clothes.getRating()));
        website.setOnClickListener(this);
        phone.setOnClickListener(this);
        location.setOnClickListener(this);
        // Inflate the layout for this fragment
        return v;
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

    // TODO: Rename method, update argument and hook method into UI event



}
